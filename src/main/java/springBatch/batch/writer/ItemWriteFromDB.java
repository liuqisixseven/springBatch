package springBatch.batch.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import springBatch.entity.FileVo;
import springBatch.mapper.FileVoMapper;

/**
 * 写方法
 *
 * @Package: com.springbatch._09item_reader_from_db
 * @ClassName: ItemWriteFromDb
 * @author: zq
 * @since: 2020/6/21 21:47
 * @version: 1.0
 * @Copyright: 2020 zq. All rights reserved.
 */
@Component("itemWriteFromDB")
public class ItemWriteFromDB implements ItemWriter<FileVo> {
	@Autowired
	FileVoMapper FileVoMapper;
    @Override
    public void write(List<? extends FileVo> fileVo) throws Exception {
 
        System.out.println("writing====================");
        System.out.println(fileVo);
        FileVoMapper.saveBatch(fileVo);
 
 
    }
}