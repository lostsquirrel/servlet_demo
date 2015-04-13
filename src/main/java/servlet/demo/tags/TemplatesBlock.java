package servlet.demo.tags;

import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class TemplatesBlock extends BodyTagSupport {

	private static final long serialVersionUID = 1L;

    private String name;
    
    private StringWriter sw = new StringWriter();
    

	@Override
	public int doStartTag() throws JspException {
		Object body = super.getValue(name);
		System.out.println("block:body " + body);
		
		return SKIP_BODY;
	}

    @Override
	public int doAfterBody() throws JspException {
		// TODO Auto-generated method stub
		return super.doAfterBody();
	}

	@Override
	public int doEndTag() throws JspException {
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
