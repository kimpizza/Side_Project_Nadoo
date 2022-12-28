package com.nanum.nadoo;

import com.nanum.nadoo.Entity.Trade;
import com.nanum.nadoo.Entity.User;
import com.nanum.nadoo.Repository.CategoryRepository;
import com.nanum.nadoo.Repository.TradeRepository;
import com.nanum.nadoo.Repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@SpringBootTest
class TradeTests {

	@Autowired
	TradeRepository tradeRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	UserRepository userRepository;

	@Test	// Trade 가데이터 생성1
	void insertSampleTrade1() {
		Trade sample1 = new Trade();
		Date startDate = new Date();	// 현재 시간을 거래 시작 시간으로

		// Calendar 객체를 사용해서 현재시간 + 5일을 종료 시간으로 설정
		Calendar cal = Calendar.getInstance();
		cal.setTime(startDate);
		cal.add(Calendar.DATE, 5);	// 5일 후
		cal.add(Calendar.HOUR_OF_DAY, 4);	// 4시간 후

		sample1.setTradeAddress("광주광역시 북구 유림로 165");
		sample1.setTradeType("가게거래");
		sample1.setTradeStart(startDate);
		sample1.setTradeEnd(new Date(cal.getTimeInMillis()));
		sample1.setTradeMax(2);
		sample1.setTradeTitle("같이 양파사실분 구합니다");
		sample1.setTradeContent("Y마트에서 양파 1망 1키로 기준으로 파는데 같이 사실분 구해요ㅠㅠㅠㅠㅠ");
		sample1.setTradeCategoryVO(categoryRepository.findByCategoryNameContaining("식료품"));
		sample1.setTradeMasterVO(userRepository.findByUserAccount("myk1234"));

		tradeRepository.save(sample1);
	}

	@Test	// Trade 가데이터 생성2
	void insertSampleTrade2() {
		Trade sample = new Trade();
		Date startDate = new Date();	// 현재 시간을 거래 시작 시간으로

		// Calendar 객체를 사용해서 현재시간 + 5일을 종료 시간으로 설정
		Calendar cal = Calendar.getInstance();
		cal.setTime(startDate);
		cal.add(Calendar.DATE, 7);	// 7일 후
		cal.add(Calendar.HOUR_OF_DAY, 8);	// 8시간 후
		cal.add(Calendar.MINUTE, 30);	// 30분 후

		sample.setTradeAddress("광주광역시 동구 동명동");
		sample.setTradeType("동네거래");
		sample.setTradeStart(startDate);
		sample.setTradeEnd(new Date(cal.getTimeInMillis()));
		sample.setTradeMax(2);
		sample.setTradeTitle("폼클렌징 1+1 나눠요");
		sample.setTradeContent("올리브영에서 폼클렌징 살건데 1+1이에요~ 반띵해서 한개씩 나눠요~~");
		sample.setTradeCategoryVO(categoryRepository.findByCategoryNameContaining("뷰티"));
		sample.setTradeMasterVO(userRepository.findByUserAccount("bsj1234"));

		tradeRepository.save(sample);
	}

	@Test	// Trade 가데이터 생성3
	void insertSampleTrade3() {
		Trade sample = new Trade();
		Date startDate = new Date();	// 현재 시간을 거래 시작 시간으로

		// Calendar 객체를 사용해서 현재시간 + 5일을 종료 시간으로 설정
		Calendar cal = Calendar.getInstance();
		cal.setTime(startDate);
		cal.add(Calendar.DATE, 3);	// 7일 후
		cal.add(Calendar.HOUR_OF_DAY, 1);	// 1시간 후
		cal.add(Calendar.MINUTE, 30);	// 30분 후

		sample.setTradeAddress("광주광역시 남구 진월동");
		sample.setTradeType("동네거래");
		sample.setTradeStart(startDate);
		sample.setTradeEnd(new Date(cal.getTimeInMillis()));
		sample.setTradeMax(3);
		sample.setTradeTitle("휴지 대량구매 같이하실분 구해요");
		sample.setTradeContent("쿠팡에서 이벤트로 클리닉스 휴지 1박스 파는데... 자취방 2개월밖에 안남아서 다 못쓸거같아요.. 같이 나누실분 2명 구해요");
		sample.setTradeCategoryVO(categoryRepository.findByCategoryNameContaining("생필품"));
		sample.setTradeMasterVO(userRepository.findByUserAccount("kyr1234"));

		tradeRepository.save(sample);
	}

	@Test
	void timeTest(){
		Date startDate = new Date();
		System.out.println("테스트 포맷 : " + startDate);

		Calendar cal = Calendar.getInstance();
		cal.setTime(startDate);
		cal.add(Calendar.DATE, 5);	// 5일 후 마감

		System.out.println("5일 후 : " + new Date(cal.getTimeInMillis()));
	}
}