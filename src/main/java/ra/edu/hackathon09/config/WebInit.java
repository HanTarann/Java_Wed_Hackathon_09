package ra.edu.hackathon09.config;
import jakarta.servlet.MultipartConfigElement;
import jakarta.servlet.ServletRegistration;
import org.jspecify.annotations.Nullable;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    private final String TMP_FILE = "";
    private final Long MAX_FILE_SIZE = 10*1024*1024L;
    private final Long MAX_REQUEST_SIZE = 50*1024*1024L;
    private final Integer FILE_SIZE_THRE_SHOLD = 10*1024*1024;

    @Override
    protected Class<?> @Nullable [] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?> @Nullable [] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setMultipartConfig(new MultipartConfigElement(this.TMP_FILE, this.MAX_FILE_SIZE, this.MAX_REQUEST_SIZE, this.FILE_SIZE_THRE_SHOLD));
    }
}
