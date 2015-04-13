package servlet.demo.tags;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class TemplatesOverride extends BodyTagSupport {

	private static final long serialVersionUID = 1L;
    
    private String name;
    
    public TemplatesOverride() {
    	super();
    }

	@Override
	public int doStartTag() throws JspException {
		System.out.println("override:" + name);
//		System.out.println("override:doStartTag" + super.getBodyContent());
		return EVAL_BODY_BUFFERED;
	}


	@Override
	public void doInitBody() throws JspException {
		// TODO Auto-generated method stub
//		System.out.println("override:doInitBody" + super.getBodyContent());
		super.doInitBody();
	}

	@Override
	public int doAfterBody() throws JspException {
//		System.out.println("override:doAfterBody" + super.getBodyContent());
		return super.doAfterBody();
	}

	@Override
	public int doEndTag() throws JspException {
		BodyContent content = super.getBodyContent();
		
		super.setValue(name, content);
		System.out.println("override:doEndTag" + super.getBodyContent());
		return 0;
	}

	@Override
	public void release() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
