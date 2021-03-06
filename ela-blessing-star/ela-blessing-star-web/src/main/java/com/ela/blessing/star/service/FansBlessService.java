package com.ela.blessing.star.service;



import com.ela.blessing.star.domain.BlessingInfo;
import com.ela.blessing.star.domain.FansBless;
import com.ela.blessing.star.domain.StarBlenssCount;
import com.ela.blessing.star.domain.StarInfo;

import java.util.List;

public interface FansBlessService {

    StarBlenssCount getStarBlessCountInfo(String star);

    List<StarBlenssCount> getStarBlessRanking();

    int saveStarBlessInfo(FansBless fansBless);

    int userExists(String star, String user);

    List<BlessingInfo> getBlessingInfo();

    int getBlessingCountToday(String userIdentity);
    int getBlessingCountNew(int starId,int id);
    List<StarInfo> getStarInfoList();
    int updateStarInfo(int starId,int blessingCount);
}
