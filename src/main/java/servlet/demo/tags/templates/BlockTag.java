package servlet.demo.tags.templates;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BlockTag extends TagSupport {

	public static String TEMPATE_FORMAT = "__jsp_override_%s__";

	private static final long serialVersionUID = 1L;

	private static Logger log = LoggerFactory.getLogger(BlockTag.class);

	private String name;

	@Override
	public int doStartTag() throws JspException {
		return getOverriedContent() == null ? EVAL_BODY_INCLUDE : SKIP_BODY;
	}

	@Override
	public int doEndTag() throws JspException {
		String overriedContent = getOverriedContent();
		if (overriedContent != null && !"".equals(overriedContent.trim())) {
			try {
				log.debug(overriedContent);
				pageContext.getOut().write(overriedContent);
			} catch (IOException e) {
				String msg = String.format("write overridedContent occer IOException,block name:%s", name);
				log.debug(msg, e);
				throw new JspException(msg , e);
			}
		}

		return EVAL_PAGE;
	}

	private String getOverriedContent() {
		String varName = String.format(TEMPATE_FORMAT, name);
		return (String) pageContext.getRequest().getAttribute(varName);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
