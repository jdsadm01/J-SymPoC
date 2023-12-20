package jp.co.jdsnet.common.entry;

import jp.co.jdsnet.common.domain.entity.syseve.TargetEntity;

public interface EntryService<T> {

  TargetEntity entry(final String trnfulcod, final String saksvcid, T dto) throws Exception;
}
