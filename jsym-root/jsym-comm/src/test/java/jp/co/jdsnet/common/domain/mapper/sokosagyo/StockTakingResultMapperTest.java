// package jp.co.jdsnet.common.domain.mapper.sokosagyo;
//
// import static org.assertj.core.api.Assertions.assertThat;
// import static org.junit.jupiter.api.Assertions.assertAll;
// import java.util.ArrayList;
// import java.util.Comparator;
// import java.util.List;
// import org.junit.jupiter.api.Nested;
// import org.junit.jupiter.params.ParameterizedTest;
// import org.junit.jupiter.params.provider.EnumSource;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.test.context.jdbc.Sql;
// import jp.co.jdsnet.common.domain.entity.sokosagyo.StockTakingResultEntity;
// import jp.co.jdsnet.common.domain.mapper.MapperTest;
// import lombok.RequiredArgsConstructor;
//
// @MapperTest
// public class StockTakingResultMapperTest {
//
// @Autowired
// private StockTakingResultMapper target;
//
// @Nested
// class selectTest {
// @RequiredArgsConstructor
// enum Param {
// CASE1_KAISKBCOD("ADI", "", "") {
// @Override
// public List<StockTakingResultEntity> getExpEntityList() {
// return getExpEntityListAll().stream()
// .filter(t -> t.getKaiskbcod().equals("ADI"))
// .sorted(Comparator.comparing(StockTakingResultEntity::getKaiskbcod)
// .thenComparing(StockTakingResultEntity::getSkocod)
// .thenComparing(StockTakingResultEntity::getKigbng))
// .toList();
//
// }
// },
// CASE2_SKOCOD("", "011", "") {
// @Override
// public List<StockTakingResultEntity> getExpEntityList() {
// return getExpEntityListAll().stream().filter(t -> t.getSkocod().equals("011"))
// .sorted(Comparator.comparing(StockTakingResultEntity::getKaiskbcod)
// .thenComparing(StockTakingResultEntity::getSkocod)
// .thenComparing(StockTakingResultEntity::getKigbng))
// .toList();
// }
// },
// CASE3_KIGBNG("", "", "TEST000000001") {
// @Override
// public List<StockTakingResultEntity> getExpEntityList() {
// return getExpEntityListAll().stream()
// .filter(t -> t.getKigbng().trim().equals("TEST000000001"))
// .sorted(Comparator.comparing(StockTakingResultEntity::getKaiskbcod)
// .thenComparing(StockTakingResultEntity::getSkocod)
// .thenComparing(StockTakingResultEntity::getKigbng))
// .toList();
// }
// },
// CASE4_1AND2("ADI", "011", "") {
// @Override
// public List<StockTakingResultEntity> getExpEntityList() {
// return getExpEntityListAll().stream().filter(t -> t.getKaiskbcod().equals("ADI"))
// .filter(t -> t.getSkocod().equals("011"))
// .sorted(Comparator.comparing(StockTakingResultEntity::getKaiskbcod)
// .thenComparing(StockTakingResultEntity::getSkocod)
// .thenComparing(StockTakingResultEntity::getKigbng))
// .toList();
//
// }
// },
// CASE5_1AND3("ADI", "", "TEST000000001") {
// @Override
// public List<StockTakingResultEntity> getExpEntityList() {
// return getExpEntityListAll().stream().filter(t -> t.getKaiskbcod().equals("ADI"))
// .filter(t -> t.getKigbng().trim().equals("TEST000000001"))
// .sorted(Comparator.comparing(StockTakingResultEntity::getKaiskbcod)
// .thenComparing(StockTakingResultEntity::getSkocod)
// .thenComparing(StockTakingResultEntity::getKigbng))
// .toList();
// }
// },
// CASE6_2AND3("", "011", "TEST000000001") {
// @Override
// public List<StockTakingResultEntity> getExpEntityList() {
// return getExpEntityListAll().stream().filter(t -> t.getSkocod().equals("011"))
// .filter(t -> t.getKigbng().trim().equals("TEST000000001"))
// .sorted(Comparator.comparing(StockTakingResultEntity::getKaiskbcod)
// .thenComparing(StockTakingResultEntity::getSkocod)
// .thenComparing(StockTakingResultEntity::getKigbng))
// .toList();
// }
// },
// CASE7_ALL("ADI", "011", "TEST000000001") {
// @Override
// public List<StockTakingResultEntity> getExpEntityList() {
// return getExpEntityListAll().stream().filter(t -> t.getKaiskbcod().equals("ADI"))
// .filter(t -> t.getSkocod().equals("011"))
// .filter(t -> t.getKigbng().trim().equals("TEST000000001"))
// .sorted(Comparator.comparing(StockTakingResultEntity::getKaiskbcod)
// .thenComparing(StockTakingResultEntity::getSkocod)
// .thenComparing(StockTakingResultEntity::getKigbng))
// .toList();
// }
// };
//
// private final String kaiskbcod;
// private final String skocod;
// private final String kigbng;
//
// public StockTakingResultEntity getInputEntity() {
// return StockTakingResultEntity.builder().kaiskbcod(kaiskbcod).skocod(skocod).kigbng(kigbng)
// .build();
// }
//
// abstract public List<StockTakingResultEntity> getExpEntityList();
//
// private static List<StockTakingResultEntity> getExpEntityListAll() {
// StockTakingResultEntity defaultEntity = StockTakingResultEntity.builder().kaiskbcod("ADI")
// .skocod("011").kigbng("TEST000000001 ").abzaikbn("A").ryofry(" ").build();
// List<StockTakingResultEntity> explist = new ArrayList<>();
// explist.add(defaultEntity.toBuilder().tnodtezkafrm(240101).tnodtezkato(240102)
// .tnodtekkafrm(240201).tnodtekkato(240202).zkazaisuu(100).kkazaisuu(200).zkateisuupls(5)
// .zkateisuumns(6).build());
// explist.add(defaultEntity.toBuilder().kaiskbcod("SME").tnodtezkafrm(240111)
// .tnodtezkato(240112).tnodtekkafrm(240211).tnodtekkato(240212).zkazaisuu(110)
// .kkazaisuu(210).zkateisuupls(15).zkateisuumns(16).build());
// explist.add(defaultEntity.toBuilder().skocod("021").tnodtezkafrm(240121).tnodtezkato(240122)
// .tnodtekkafrm(240221).tnodtekkato(240222).zkazaisuu(120).kkazaisuu(220).zkateisuupls(25)
// .zkateisuumns(26).build());
// explist.add(defaultEntity.toBuilder().kigbng("TEST000000002 ")
// .tnodtezkafrm(240131)
// .tnodtezkato(240132).tnodtekkafrm(240231).tnodtekkato(240232).zkazaisuu(130)
// .kkazaisuu(230).zkateisuupls(35).zkateisuumns(36).build());
//
// return explist;
// }
// }
//
// @ParameterizedTest
// @EnumSource
// @Sql("/sql/sokosagyo/selectTest_dataset.sql")
// void test(Param param) {
// List<StockTakingResultEntity> result = target.selectTest(param.getInputEntity()).stream()
// .sorted(Comparator.comparing(StockTakingResultEntity::getKaiskbcod)
// .thenComparing(StockTakingResultEntity::getSkocod)
// .thenComparing(StockTakingResultEntity::getKigbng))
// .toList();
//
// List<StockTakingResultEntity> exp = param.getExpEntityList();
// assertAll(() -> assertThat(result.size()).isEqualTo(exp.size()), () -> {
// for (int i = 0; i < result.size(); i++) {
// assertThat(result.get(i).toString()).isEqualTo(exp.get(i).toString());
// }
// });
// }
//
// }
// }
