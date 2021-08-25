package springBatch.batch.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springBatch.batch.writer.ItemWriteFromDB;
import springBatch.entity.FileVo;

@Configuration
public class StepConfig{
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
    @Bean("itemReaderFromDBJobStep")
	public Step itemReaderFromDBJobStep(
			@Qualifier("FlatFileItemReader")FlatFileItemReader<FileVo> reader,
			@Qualifier("processor")ItemProcessor<FileVo,FileVo> process,
			@Qualifier("itemWriteFromDB")ItemWriteFromDB writer) {
	return stepBuilderFactory.get("itemReaderFromDBJobStep")
            .<FileVo, FileVo>chunk(2)
            .reader(reader)
            .writer(writer)
            .build();
	}
}
