package edp.core.utils;

import org.jetbrains.annotations.NotNull;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.resource.ResourceResolver;
import org.springframework.web.servlet.resource.ResourceResolverChain;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

public class TxtResourceResolver implements ResourceResolver {

    private final ResourceResolver delegate;

    public TxtResourceResolver(ResourceResolver delegate) {
        this.delegate = delegate;
    }

    @Override
    public Resource resolveResource(HttpServletRequest request, String requestPath, @NotNull List<? extends Resource> locations, @NotNull ResourceResolverChain chain) {
        // 检查请求路径是否以 .txt 结尾
        if (requestPath.endsWith(".txt")) {
            // 如果是,则返回 null 以触发 404
            return null;
        }
        // 对于其他请求路径,使用默认行为处理
        return delegate.resolveResource(request, requestPath, locations, chain);
    }

    @Override
    public String resolveUrlPath(@NotNull String resourcePath, @NotNull List<? extends Resource> locations, @NotNull ResourceResolverChain chain) {
        return delegate.resolveUrlPath(resourcePath, locations, chain);
    }
}