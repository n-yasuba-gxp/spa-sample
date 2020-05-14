package jp.co.gxp.sample.backend.support;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

import javax.servlet.http.HttpServletRequest;

@Configuration
public class RequestLoggingConfig {

    @Bean
    public CommonsRequestLoggingFilter requestLoggingFilter() {
        CommonsRequestLoggingFilter filter = new CraftCommonRequestLoggingFilter();
        filter.setIncludeClientInfo(false);
        filter.setIncludeQueryString(true);
        filter.setIncludeHeaders(false);
        filter.setIncludePayload(true);
        filter.setMaxPayloadLength(1024);
        return filter;
    }

    static class CraftCommonRequestLoggingFilter extends CommonsRequestLoggingFilter {

        @Override
        protected boolean shouldLog(HttpServletRequest request) {
            // apiのアクセスログ以外は無視
            if (!request.getRequestURI().contains("/api/")) {
                return false;
            }
            return logger.isDebugEnabled();
        }
    }
}