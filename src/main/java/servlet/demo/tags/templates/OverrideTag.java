package servlet.demo.tags.templates;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OverrideTag extends BodyTagSupport {

	private static final long serialVersionUID = 1L;
    
	@SuppressWarnings("unused")
	private static Logger log = LoggerFactory.getLogger(OverrideTag.class);
	
    private String name;
    
	@Override
	public int doStartTag() throws JspException {
		return isOverrided() ? SKIP_BODY : EVAL_BODY_BUFFERED;
	}

	@Override
	public int doEndTag() throws JspException {
		if (!isOverrided()) {
			BodyContent bodyContent = getBodyContent();
			String varName = String.format(BlockTag.TEMPATE_FORMAT, name);
			pageContext.getRequest().setAttribute(varName, bodyContent.getString());
		}
		return EVAL_PAGE;
	}

	private boolean isOverrided() {
		String varName = String.format(BlockTag.TEMPATE_FORMAT, name);
		Object content = pageContext.getRequest().getAttribute(varName);
		return content != null;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
