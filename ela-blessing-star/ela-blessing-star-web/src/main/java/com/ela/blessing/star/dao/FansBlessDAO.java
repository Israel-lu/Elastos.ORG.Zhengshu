package com.ela.blessing.star.dao;

import com.ela.blessing.star.domain.FansBless;
import com.ela.blessing.star.domain.StarBlenssCount;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;

import java.util.List;
@Mapper
public interface FansBlessDAO {

    @Select("SELECT star_name,COUNT(1) as blessing_count FROM fans_bless WHERE star_id=#{starId} group by star_name")
    StarBlenssCount getStarBlessCount(@Param("starId") String starId);

    @Select("select star_id,star_name,count(1) as blessing_count from fans_bless group by star_id order by count(1) desc ")
    List<StarBlenssCount> getStarBlessList();

    @Insert("insert into fans_bless(user_identity,user_nick,star_id,star_name,emoticon_id,blessing_content,txid,ctime) values(#{fansBless.userIdentity},#{fansBless.userNick},#{fansBless.starId},#{fansBless.starName},#{fansBless.emoticonId},#{fansBless.blessingContent},#{fansBless.txid},now())")
    @SelectKey(before=false,keyProperty="fansBless.id",resultType=Integer.class,statementType=StatementType.STATEMENT,statement="SELECT LAST_INSERT_ID() AS id")
    Integer saveStarBless(@Param("fansBless")FansBless fansBless);

    @Select("select count(1) from fans_bless where star_id=#{starId} and user_identity=#{user}")
    int getExists(@Param("user") String userIdentity, @Param("starId") String starId);

    @Select("SELECT COUNT(1) AS COUNT FROM fans_bless WHERE user_identity=#{openId}  AND DATE(ctime)=DATE(NOW())")
    int getBlessingCountToday(@Param("openId")String openId);

    @Select("SELECT COUNT(1) FROM fans_bless WHERE star_id=#{starId} AND id <=#{id}")
    int getBlessingCountNew(@Param("starId")int starId,@Param("id")int id);
}
