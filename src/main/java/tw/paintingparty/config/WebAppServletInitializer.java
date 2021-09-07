package tw.paintingparty.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import tw.paintingparty.util.AllPatternFilter;

//等同於web.xml
public class WebAppServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override   //用來設定等同於beans.config.xml
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {RootAppConfig.class};  
		//return null;
	}

	@Override   //用來設定等同於mvc-serlvet.xml
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {WebAppMvcConfig.class};
		//return null;
	}

	@Override   
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter cefilter = new CharacterEncodingFilter();
		cefilter.setEncoding("UTF-8");
		cefilter.setForceEncoding(true);
		
		AllPatternFilter alpfilter = new AllPatternFilter();
		
		return new Filter[] {cefilter,alpfilter};
	}
	
	

}
