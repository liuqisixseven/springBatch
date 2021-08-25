package springBatch.batch.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import springBatch.entity.FileVo;

@Component("processor")
public class Processor implements ItemProcessor<FileVo, FileVo>{
	@Override
	public FileVo process(FileVo fileVo) throws Exception{
		if(fileVo.getSex().equals("1")) {
			fileVo.setSex("男");
		}else if(fileVo.getSex().equals("2")) {
			fileVo.setSex("女");
		}
		return fileVo;
	}
}
