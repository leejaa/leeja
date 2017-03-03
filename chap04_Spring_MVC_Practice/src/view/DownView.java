package view;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

@Component
public class DownView extends AbstractView {
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map map = (Map)model.get("map");
		System.out.println(map);
		response.setHeader("Content-Disposition", "attachment;filename=\""+map.get("FILENAME")+"\"");
		
		OutputStream os = response.getOutputStream();
		String address =(String)map.get("FILEADDRESS");
		InputStream is = new FileInputStream(new File(address));
		
		FileCopyUtils.copy(is, os);
		
	}
}
