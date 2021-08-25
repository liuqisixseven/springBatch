package springBatch.batch.reader;


import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import springBatch.entity.FileVo;

@Component
public class Reader {
	
	@StepScope
	@Bean("FlatFileItemReader")
	public FlatFileItemReader<FileVo> itemReaderFromDB(){
		FlatFileItemReader<FileVo> reader = new FlatFileItemReader<FileVo>();
		reader.setResource(new ClassPathResource("test.txt"));  //获取文件
		reader.setLinesToSkip(6);  //忽略前6行
		DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
		tokenizer.setDelimiter("|");  //分隔符为‘|’
		tokenizer.setNames("name","sex","age","tel","company","email");  //获取列
		DefaultLineMapper<FileVo> mapper = new DefaultLineMapper<FileVo>();
		mapper.setLineTokenizer(tokenizer);
		
		mapper.setFieldSetMapper(fieldSet->{
			FileVo fileVo = new FileVo();
			fileVo.setName(fieldSet.readString("name"));
			fileVo.setSex(fieldSet.readString("sex"));
			fileVo.setAge(fieldSet.readString("age"));
			fileVo.setTel(fieldSet.readString("tel"));
			fileVo.setCompany(fieldSet.readString("company"));
			fileVo.setEmail(fieldSet.readString("email"));
			return fileVo;
		});
		reader.setLineMapper(mapper);
		return reader;
	}
}
