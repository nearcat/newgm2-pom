package com.golfzon.newgm2.infra.config.common.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

/**
 * API Wapper Class
 * com.golfzon.newgm2.infra.config.common.domain GmWapper.java
 * 
 * @author sjisbmoc
 * @since
 * @version 1.0
 * @see
 * 
 *      <pre>
 * == 계정이력(Modification Infomation) ==
 * 
 * 수정일			수정자		수정내용
 * ----------------------------------------
 * 2021. 4. 5.	sjisbmoc		최초생성
 * 
 *      </pre>
 */
@JsonSerialize
@JsonInclude(Include.NON_NULL)
@Data
public class GmWapper implements Serializable {

	private static final long serialVersionUID = -3076389675697823644L;

	private String rltCd;	// 결과 코드
	private String rltMsg;	// 결과 메시지
	private Object rltObj;	// 결과 객체

	public GmWapper() {
	}

	public GmWapper(String rltCd, String rltMsg) {
		super();
		setRltCd(rltCd);
		setRltMsg(rltMsg);
	}

	public GmWapper(String rltCd, String rltMsg, Object rltObj) {
		setRltCd(rltCd);
		setRltMsg(rltMsg);
		setRltObj(rltObj);
	}

}
