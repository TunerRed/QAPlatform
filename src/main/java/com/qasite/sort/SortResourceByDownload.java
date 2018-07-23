package com.qasite.sort;

import com.qasite.bean.Resource;
import com.qasite.bean.SearchResult;

public class SortResourceByDownload implements SortStrategy{

    @Override
    public int compare(SearchResult o1, SearchResult o2) {
        Resource q_origin = (Resource)o1;
        Resource q_other = (Resource)o2;
        if (q_origin.getDownloadTimes()>q_other.getDownloadTimes())
            return -1;
        else if (q_origin.getDownloadTimes()<q_other.getDownloadTimes())
            return 1;
        return 0;
    }
}
