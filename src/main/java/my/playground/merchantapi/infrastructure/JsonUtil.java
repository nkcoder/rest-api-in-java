package my.playground.merchantapi.infrastructure;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import java.io.IOException;
import java.io.InputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class JsonUtil {

  private static final Logger logger = LoggerFactory.getLogger(JsonUtil.class);
  private final static ObjectMapper objectMapper = new ObjectMapper();

  static {
    objectMapper.registerModule(new ParameterNamesModule());
  }

  public <T> T readValue(InputStream inputStream, Class<T> valueType) {
    try {
      return objectMapper.readValue(inputStream, valueType);
    } catch (IOException ex) {
      logger.error("Cannot deserialize data: {}", ex.getMessage());
      throw new RuntimeException("cannot read data to object", ex);
    }
  }

}
