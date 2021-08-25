package springBatch.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import springBatch.entity.FileVo;

@Mapper
public interface FileVoMapper {
	int saveBatch(@Param("fileVo")List<? extends FileVo> fileVo);
}
