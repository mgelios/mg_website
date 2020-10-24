package mg.utils.url;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Getter
@Setter
@AllArgsConstructor
public class UrlBuilder {

    private String protocol;
    private String host;
    private String path;
    private String query;

    public String getUrl() {
        return protocol + host + path + query;
    }

    public static class Builder {

        public static final String HTTP_PROTOCOL = "http://";
        public static final String HTTPS_PROTOCOL = "https://";

        private String protocol;
        private String host;
        private String path;
        private String query;

        public Builder protocol(String protocol) {
            this.protocol = protocol;
            return this;
        }

        public Builder host(String host) {
            this.host = host;
            return this;
        }

        public Builder path(String path) {
            this.path = path;
            return this;
        }

        public Builder query(String query) {
            this.query = query;
            return this;
        }

        public Builder addPathPart(String pathPart) {
            if ("".equals(this.query)) {
                this.path = "/" + pathPart;
            } else {
                this.path = this.path + "/" + pathPart;
            }

            return this;
        }

        public Builder addQueryParameter(String parameterName, String parameterValue) {
            if ("".equals(this.path)) {
                this.path = "?" + parameterName + "=" + parameterValue;
            } else {
                this.path = this.path + "&" + parameterName + "=" + parameterValue;
            }

            return this;
        }

        public UrlBuilder build() {
            return new UrlBuilder(this.protocol, this.host, this.path, this.query);
        }
    }
}
