package com.wptdxii.uikit.widget.recyclerview.expandable;

import java.util.ArrayList;
import java.util.List;

/**
 * a abstract helper to implement expandable item
 * if don't want to extend this class, implement interface IExpandablen directly
 * Created by wptdxii on 2016/10/14 0014.
 */

public class AbsExpandableItem<T> implements IExpandable<T> {
    protected boolean mExpandable;
    protected List<T> mSubDataList;

    @Override
    public boolean isExpandable() {
        return this.mExpandable;
    }

    @Override
    public void setExpandable(boolean expandable) {
        this.mExpandable = expandable;
    }

    @Override
    public List<T> getData() {
        return mSubDataList;
    }

    @Override
    public int getLevel() {
        return 0;
    }

    public void setData(List<T> dataList) {
        this.mSubDataList = dataList;
    }

    public T getData(int positon) {
        if (mSubDataList != null && mSubDataList.size() > 0 &&
                positon < mSubDataList.size()) {
            return mSubDataList.get(positon);
        } else {
            return null;
        }
    }

    public void addData(T itemData) {
        if (mSubDataList == null) {
            mSubDataList = new ArrayList<>();
        }

        mSubDataList.add(itemData);
    }

    /**
     * if the position out of data size, then add the data to the end of the data collection
     * @param position
     * @param itemData
     */
    public void addData(int position, T itemData) {
        if (mSubDataList != null && position >= 0 && position < mSubDataList.size()) {
            mSubDataList.add(position, itemData);
        } else {
            addData(itemData);
        }
    }

    public boolean removeData(T itemData) {
        return mSubDataList != null && mSubDataList.remove(itemData);
    }


    public boolean contains(T itemData) {
        return mSubDataList != null && mSubDataList.contains(itemData);
    }
}
