package mg.utils.url;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Getter
@Setter
@AllArgsConstructor
public class UrlBuilder {

    private String protocol;
    private String host;
    private String query;

    public static class Builder {

        private String protocol;
        private String host;
        private String query;

        public Builder protocol(String protocol) {
            this.protocol = protocol;
            return this;
        }

        public Builder host(String host) {
            this.host = host;
            return this;
        }

        public Builder query(String query) {
            this.query = query;
            return this;
        }

        public UrlBuilder build() {
            return new UrlBuilder(this.protocol, this.host, this.query);
        }
    }
}
