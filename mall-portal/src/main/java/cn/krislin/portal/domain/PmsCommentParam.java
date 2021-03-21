package cn.krislin.portal.domain;

import cn.krislin.mbg.model.PmsComment;
import cn.krislin.mbg.model.PmsCommentReplay;
import lombok.Data;

import java.util.List;

/**
 * 评论参数
 **/
@Data
public class PmsCommentParam extends PmsComment {
    private List<PmsCommentReplay> pmsCommentReplayList;
}
