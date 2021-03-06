package com.cn.philips.service.impl;

import java.util.List;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.philips.dao.CcdTestConfigMapper;
import com.cn.philips.dao.CcdTestDataMapper;
import com.cn.philips.dao.CcdTestPlanMapper;
import com.cn.philips.dao.CcdTestRuleMapper;
import com.cn.philips.dao.G11MatrixMapper;
import com.cn.philips.dao.G12MatrixMapper;
import com.cn.philips.dao.G22MatrixMapper;
import com.cn.philips.pojo.AvgTestData;
import com.cn.philips.pojo.CcdTestConfig;
import com.cn.philips.pojo.CcdTestConfigExample;
import com.cn.philips.pojo.CcdTestConfigResponse;
import com.cn.philips.pojo.CcdTestData;
import com.cn.philips.pojo.CcdTestDataExample;
import com.cn.philips.pojo.CcdTestPlan;
import com.cn.philips.pojo.CcdTestPlanExample;
import com.cn.philips.pojo.CcdTestPlanNew;
import com.cn.philips.pojo.CcdTestResault;
import com.cn.philips.pojo.CcdTestRuleExample;
import com.cn.philips.pojo.G11Matrix;
import com.cn.philips.pojo.G11MatrixExample;
import com.cn.philips.pojo.G12Matrix;
import com.cn.philips.pojo.G12MatrixExample;
import com.cn.philips.pojo.G22Matrix;
import com.cn.philips.pojo.G22MatrixExample;
import com.cn.philips.service.DataHandleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("dataHandleService")
public class DataHandleServiceImpl implements DataHandleService {

	@Resource
	private CcdTestDataMapper ccdTestDataMapper;

	@Resource
	private CcdTestPlanMapper ccdTestPlanMapper;

	@Resource
	private CcdTestRuleMapper ccdTestRuleMapper;

	@Resource
	private G11MatrixMapper g11MatrixMapper;

	@Resource
	private G12MatrixMapper g12MatrixMapper;

	@Resource
	private G22MatrixMapper g22MatrixMapper;

	@Resource
	private CcdTestConfigMapper ccdTestConfigMapper;

	@Override
	public ArrayList<CcdTestData> GetAllTestData(String planName) throws Exception {
		CcdTestDataExample ccdTestDataExample = new CcdTestDataExample();
		CcdTestDataExample.Criteria criteria = ccdTestDataExample.createCriteria();
		criteria.andPlanNameEqualTo(planName);
		ArrayList<CcdTestData> ccdTestDataList = new ArrayList<CcdTestData>();
		ccdTestDataList = ccdTestDataMapper.selectByExample(ccdTestDataExample);
		if (ccdTestDataList.size() == 0) {
			throw new Exception("test data not exist");
		}
		return ccdTestDataList;
	}

	@Override
	public AvgTestData GetAvg(String planName, ArrayList<CcdTestData> ccdTestDataList) {

		// TODO Auto-generated method stub
		AvgTestData avgTestData = new AvgTestData();

		Double maxBri = GetMaxBri(ccdTestDataList);

		CcdTestConfig ccdTestConfig = GetCcdTestConfig(planName);
		Double threshold = ccdTestConfig.getThreshold();

		ArrayList<CcdTestData> effectiveCCDtestDataList = GetEffectiveTestData(planName, ccdTestDataList, maxBri);

		Double sumWeightBri = 0.0000000;
		Double sigmaWeightBri = 0.0000000;
		Double sigmaWeightX = 0.0000000;
		Double sigmaWeightY = 0.0000000;
		Double sigmaWeightU = 0.0000000;
		Double sigmaWeightV = 0.0000000;
		Double sigmaDeltaUV = 0.0000000;
		Double deltaUV = 0.0000000;
		Double maxDeltaUV = 0.0000000;

		for (CcdTestData effectiveCcdTestData : effectiveCCDtestDataList) {
			// Double weightBri = effectiveCCDtestData.getBri();
			sumWeightBri = sumWeightBri + effectiveCcdTestData.getBri();
			sigmaWeightBri = sigmaWeightBri + effectiveCcdTestData.getBri() * effectiveCcdTestData.getBri();
			sigmaWeightX = sigmaWeightX + effectiveCcdTestData.getX() * effectiveCcdTestData.getBri();
			sigmaWeightY = sigmaWeightY + effectiveCcdTestData.getY() * effectiveCcdTestData.getBri();
			sigmaWeightU = sigmaWeightU + effectiveCcdTestData.getU() * effectiveCcdTestData.getBri();
			sigmaWeightV = sigmaWeightV + effectiveCcdTestData.getV() * effectiveCcdTestData.getBri();
		}
		avgTestData.setMaxBri(maxBri);
		avgTestData.setAvgBri(sigmaWeightBri / sumWeightBri);
		avgTestData.setAvgX(sigmaWeightX / sumWeightBri);
		avgTestData.setAvgY(sigmaWeightY / sumWeightBri);
		avgTestData.setAvgU(sigmaWeightU / sumWeightBri);
		avgTestData.setAvgV(sigmaWeightV / sumWeightBri);

		for (CcdTestData effectiveCcdTestData : effectiveCCDtestDataList) {
			deltaUV = Math.sqrt(Math.pow((effectiveCcdTestData.getU() - avgTestData.getAvgU()), 2)
					+ Math.pow((effectiveCcdTestData.getV() - avgTestData.getAvgV()), 2));
			if (deltaUV > maxDeltaUV) {
				maxDeltaUV = deltaUV;
			}
			sigmaDeltaUV = sigmaDeltaUV + deltaUV;
		}

		avgTestData.setAvgDeltaUV(sigmaDeltaUV / effectiveCCDtestDataList.size());
		avgTestData.setMaxDeltaUV(maxDeltaUV);

		return avgTestData;
	}

	@Override
	public Map<String, Double> CalculateEllipticVaule(AvgTestData avgTestData) {
		Double a = 0.000000;
		Double b = 0.000000;
		Double q = 0.000000;
		Double g11 = CalculateGVaule("G11", avgTestData);
		Double g12 = CalculateGVaule("G12", avgTestData);
		Double g22 = CalculateGVaule("G22", avgTestData);

		if (g12 < (Math.sqrt(g11 * g22) * -0.995)) {
			g12 = (Math.sqrt(g11 * g22) * -0.995);
		}
		if (g12 > Math.sqrt(g11 * g22) * 0.995) {
			g12 = Math.sqrt(g11 * g22) * 0.995;
		}

		if (g12 == 0.0) {
			q = 0.0;
			a = 1 / Math.sqrt(g11);
			b = 1 / Math.sqrt(g22);

		} else if (g11 == g12) {
			q = Math.PI / 4;
			a = Math.sqrt(1 / (g22 + g12));
			b = Math.sqrt(1 / (g11 - g12));
		} else {
			q = 0.5 * Math.atan(2 * g12 / (g11 - g22));
			a = Math.sqrt(1 / (g22 + g12 / Math.tan(q)));
			b = Math.sqrt(1 / (g11 - g12 / Math.tan(q)));
			if (a < b) {
				double c = a;
				a = b;
				b = c;
				q = q + Math.PI / 2;
			}
			if (q >= Math.PI) {
				q = q - Math.PI;
			}
		}
		Map<String, Double> ellipticMap = new HashMap<String, Double>();
		ellipticMap.put("A", a);
		ellipticMap.put("B", b);
		ellipticMap.put("Q", q);

		return ellipticMap;
	}

	@Override
	public List<Double> CalculatePixelPointRang(AvgTestData avgTestData,
			ArrayList<CcdTestData> effectiveCcdTestDataList, Map<String, Double> gValueMap,
			CcdTestConfig ccdTestConfig) {
		// TODO Auto-generated method stub
		Double u = 0.000000;
		Double v = 0.000000;

		List<Integer> sdcmStepList = new ArrayList<Integer>();
		sdcmStepList.add(ccdTestConfig.getSdcm1());
		sdcmStepList.add(ccdTestConfig.getSdcm2());
		sdcmStepList.add(ccdTestConfig.getSdcm3());
		sdcmStepList.add(ccdTestConfig.getSdcm4());
		sdcmStepList.add(ccdTestConfig.getSdcm5());
		List<Double> CalculatePixelResaultList = new ArrayList<Double>();
		for (Integer step : sdcmStepList) {

			Integer count = 0;

			for (CcdTestData ccdTestData : effectiveCcdTestDataList) {
				u = ((ccdTestData.getX() - avgTestData.getAvgX()) * Math.cos(gValueMap.get("Q")))
						+ ((ccdTestData.getY() - avgTestData.getAvgY()) * Math.sin(gValueMap.get("Q")));
				v = ((ccdTestData.getX() - avgTestData.getAvgX()) * Math.sin(gValueMap.get("Q")))
						- ((ccdTestData.getY() - avgTestData.getAvgY()) * Math.cos(gValueMap.get("Q")));
				double distance = (u * u) / Math.pow((step * gValueMap.get("A")), 2)
						+ (v * v) / Math.pow((step * gValueMap.get("B")), 2);
				if (distance < 1) {
					count++;
				}
			}

			double listSize = effectiveCcdTestDataList.size();
			double listPercent = Double.valueOf(count.doubleValue()) / listSize;
			// NumberFormat fmt = NumberFormat.getPercentInstance();
			// fmt.setMaximumFractionDigits(2);
			// CalculatePixelResaultList.add(fmt.format(listPercent));
			CalculatePixelResaultList.add(listPercent);
		}
		return CalculatePixelResaultList;
	}

	@Override
	public Double CalculateGVaule(String TypeOfValue, AvgTestData avgTestData) {

		Double som = new Double(0.0000000);
		Double d = new Double(0.0000000);
		Double g = new Double(0.0000000);

		if (TypeOfValue.equals("G11")) {
			G11MatrixExample g11MatrixExample = new G11MatrixExample();
			G11MatrixExample.Criteria criteria = g11MatrixExample.createCriteria();
			ArrayList<G11Matrix> g11MatrixList = g11MatrixMapper.selectByExample(g11MatrixExample);
			for (G11Matrix g11Matrix : g11MatrixList) {
				d = Math.sqrt(
						(g11Matrix.getXg11() - avgTestData.getAvgX()) * (g11Matrix.getXg11() - avgTestData.getAvgX())
								+ (g11Matrix.getYg11() - avgTestData.getAvgY())
										* (g11Matrix.getYg11() - avgTestData.getAvgY()));
				if (d > 0) {
					som = som + g11Matrix.getWg11() * d * d * (Math.log(d) - 1);
				}
			}
			g = som * 10000;
		}
		if (TypeOfValue.equals("G12")) {
			G12MatrixExample g12MatrixExample = new G12MatrixExample();
			G12MatrixExample.Criteria criteria = g12MatrixExample.createCriteria();
			ArrayList<G12Matrix> g12MatrixList = g12MatrixMapper.selectByExample(g12MatrixExample);
			for (G12Matrix g12Matrix : g12MatrixList) {
				d = Math.sqrt(
						(g12Matrix.getXg12() - avgTestData.getAvgX()) * (g12Matrix.getXg12() - avgTestData.getAvgX())
								+ (g12Matrix.getYg12() - avgTestData.getAvgY())
										* (g12Matrix.getYg12() - avgTestData.getAvgY()));
				if (d > 0) {
					som = som + g12Matrix.getWg12() * d * d * (Math.log(d) - 1);
				}
			}
			g = som * 10000 * 0.5;
		}
		if (TypeOfValue.equals("G22")) {
			G22MatrixExample g22MatrixExample = new G22MatrixExample();
			G22MatrixExample.Criteria criteria = g22MatrixExample.createCriteria();
			ArrayList<G22Matrix> g22MatrixList = g22MatrixMapper.selectByExample(g22MatrixExample);
			for (G22Matrix g22Matrix : g22MatrixList) {
				d = Math.sqrt(
						(g22Matrix.getXg22() - avgTestData.getAvgX()) * (g22Matrix.getXg22() - avgTestData.getAvgX())
								+ (g22Matrix.getYg22() - avgTestData.getAvgY())
										* (g22Matrix.getYg22() - avgTestData.getAvgY()));
				if (d > 0) {
					som = som + g22Matrix.getWg22() * d * d * (Math.log(d) - 1);
				}
			}
			g = som * 10000;
		}

		return g;
	}

	public Double GetMaxBri(ArrayList<CcdTestData> ccdTestDataList) {
		// TODO Auto-generated method stub
		ArrayList<Double> briList = new ArrayList();
		Double maxValue = 0.00000;
		for (CcdTestData ccdtestData : ccdTestDataList) {
			if (maxValue < ccdtestData.getBri()) {
				maxValue = ccdtestData.getBri();
			}
		}
		return maxValue;
	}

	public ArrayList<CcdTestData> GetEffectiveTestData(String planName, ArrayList<CcdTestData> ccdTestDataList,
			Double maxBri) {

		CcdTestPlan ccdTestPlan = GetCcdTestPlanByName(planName);
		Integer planId = ccdTestPlan.getId();

		CcdTestConfig ccdTestConfig = GetCcdTestConfig(planName);
		Double threshold = ccdTestConfig.getThreshold();

		ArrayList<CcdTestData> effctiveCCDtestDataList = new ArrayList<CcdTestData>();
		Integer lenX = ccdTestPlan.getPixelX();
		Integer lenY = ccdTestPlan.getPixelY();

		for (int i = 0; i < lenX; i++) {
			List<CcdTestData> tmpList = ccdTestDataList.subList(i * lenY, (i + 1) * lenY);
			for (int j = 0; j < lenY; j++) {
				if (j > 0 && j < lenY - 1) {
					if ((tmpList.get(j).getBri()) / maxBri >= threshold) {
						effctiveCCDtestDataList.add(tmpList.get(j));
					}
					if ((tmpList.get(j).getBri()) / maxBri < threshold) {
						int sumK = 0;
						int sumL = 0;
						for (int k = 0; k < j; k++) {
							if ((tmpList.get(k).getBri()) / maxBri >= threshold) {
								sumK = sumK + 1;
							}
						}
						for (int l = j + 1; l < lenY; l++) {
							if ((tmpList.get(l).getBri()) / maxBri >= threshold) {
								sumL = sumL + 1;
							}
						}
						if (sumK > 0 && sumL > 0) {
							effctiveCCDtestDataList.add(tmpList.get(j));
						}
					}
				}
			}
		}
		return effctiveCCDtestDataList;
	}

	@Override
	public ArrayList<String> GetPlanNameList() {
		CcdTestPlanExample ccdTestPlanExample = new CcdTestPlanExample();
		CcdTestPlanExample.Criteria criteria = ccdTestPlanExample.createCriteria();
		ArrayList<CcdTestPlan> ccdTestPlanList = ccdTestPlanMapper.selectByExample(ccdTestPlanExample);
		ArrayList planNameList = new ArrayList();
		for (CcdTestPlan ccdTestPlan : ccdTestPlanList) {
			planNameList.add(ccdTestPlan.getPlanName());
		}
		return planNameList;
	}

	@Override
	public ArrayList<CcdTestPlanNew> GetPlanList(Integer start, Integer limit) {
		CcdTestPlanExample ccdTestPlanExample = new CcdTestPlanExample();
		CcdTestPlanExample.Criteria criteria = ccdTestPlanExample.createCriteria();
		ccdTestPlanExample.setStart(start);
		ccdTestPlanExample.setLimit(limit);
		ArrayList<CcdTestPlan> ccdTestPlanList = ccdTestPlanMapper.selectByExample(ccdTestPlanExample);

		// convert to final format
		ArrayList<CcdTestPlanNew> ccdTestPlanListNew = new ArrayList();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for (CcdTestPlan ccdTestPlan : ccdTestPlanList) {
			CcdTestPlanNew ccdTestPlanNew = new CcdTestPlanNew();
			ccdTestPlanNew.setId(ccdTestPlan.getId());
			ccdTestPlanNew.setPlanName(ccdTestPlan.getPlanName());
			ccdTestPlanNew.setDescription(ccdTestPlan.getDescription());
			ccdTestPlanNew.setPixelX(ccdTestPlan.getPixelX());
			ccdTestPlanNew.setPixelY(ccdTestPlan.getPixelY());
			ccdTestPlanNew.setOperatorName(ccdTestPlan.getOperatorName());
			ccdTestPlanNew.setStartTime(sdf.format(ccdTestPlan.getStartTime()));
			ccdTestPlanListNew.add(ccdTestPlanNew);
		}
		return ccdTestPlanListNew;
	}

	@Override
	public PageInfo<CcdTestPlan> GetPlanListNew(Map<String, String> params) {
		// TODO Auto-generated method stub
		String planName = "";
		Integer pageSize = 10;
		Integer pageNum = 1;
		Date starttime = null;
		Date endtime = null;
		List<CcdTestPlan> list = null;
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			for (String s : params.keySet()) {
				if (s.equals("planName"))
					planName = params.get(s);
				else if (s.equals("pageSize"))
					pageSize = Integer.parseInt(params.get("pageSize"));
				else if (s.equals("pageNum"))
					pageNum = Integer.parseInt(params.get("pageNum"));
				else if (s.equals("startDate") && !"".equals(params.get("starttime")))
					starttime = format.parse(params.get("starttime"));
				else if (s.equals("endDate") && !"".equals(params.get("endtime")))
					endtime = format.parse(params.get("endtime"));
			}
		} catch (ParseException e) {
			starttime = endtime = null;
		}
		PageHelper.startPage(pageNum, pageSize);
		CcdTestPlanExample ccdTestPlanExample = new CcdTestPlanExample();
		CcdTestPlanExample.Criteria criteria = ccdTestPlanExample.createCriteria();
		if (!planName.isEmpty()) {
			criteria.andPlanNameEqualTo(planName);
			
		};
		if (starttime != null) {
			criteria.andStartTimeGreaterThan(starttime);
		};
		if (starttime != null) {
			criteria.andStartTimeLessThan(starttime);
		};
		list = ccdTestPlanMapper.selectByExample(ccdTestPlanExample);
		PageInfo<CcdTestPlan> pageInfo = new PageInfo<CcdTestPlan>(list);
		return pageInfo;
	}

	@Override
	public CcdTestConfig GetCcdTestConfig(String planName) {

		CcdTestPlan ccdTestPlan = GetCcdTestPlanByName(planName);

		Integer planId = ccdTestPlan.getId();

		CcdTestConfig ccdTestConfig = new CcdTestConfig();
		List<CcdTestConfig> ccdTestConfigList = new ArrayList<CcdTestConfig>();
		CcdTestConfigExample ccdTestConfigExample = new CcdTestConfigExample();
		CcdTestConfigExample.Criteria criteria1 = ccdTestConfigExample.createCriteria();
		criteria1.andPlanidEqualTo(planId);
		ccdTestConfigList = ccdTestConfigMapper.selectByExample(ccdTestConfigExample);
		// TODO Auto-generated method stub
		return ccdTestConfigList.get(0);
	}

	@Override
	public List<CcdTestConfigResponse> GetCcdTestConfigList() {
		List<CcdTestConfig> ccdTestConfigList = new ArrayList<CcdTestConfig>();
		CcdTestConfigExample ccdTestConfigExample = new CcdTestConfigExample();
		CcdTestConfigExample.Criteria criteria = ccdTestConfigExample.createCriteria();
		ccdTestConfigList = ccdTestConfigMapper.selectByExample(ccdTestConfigExample);
		List<CcdTestConfigResponse> ccdTestConfigResponseList = new ArrayList<CcdTestConfigResponse>();
		for (CcdTestConfig ccdTestConfig : ccdTestConfigList) {
			CcdTestPlan ccdTestPlan = ccdTestPlanMapper.selectByPrimaryKey(ccdTestConfig.getPlanid());
			CcdTestConfigResponse ccdTestConfigResponseTemp = new CcdTestConfigResponse();
			ccdTestConfigResponseTemp.setId(ccdTestConfig.getId());
			ccdTestConfigResponseTemp.setPlanid(ccdTestConfig.getPlanid());
			ccdTestConfigResponseTemp.setThreshold(ccdTestConfig.getThreshold());
			ccdTestConfigResponseTemp.setPlanName(ccdTestPlan.getPlanName());
			ccdTestConfigResponseTemp.setSdcm1(ccdTestConfig.getSdcm1());
			ccdTestConfigResponseTemp.setSdcm2(ccdTestConfig.getSdcm2());
			ccdTestConfigResponseTemp.setSdcm3(ccdTestConfig.getSdcm3());
			ccdTestConfigResponseTemp.setSdcm4(ccdTestConfig.getSdcm4());
			ccdTestConfigResponseTemp.setSdcm5(ccdTestConfig.getSdcm5());
			ccdTestConfigResponseList.add(ccdTestConfigResponseTemp);
		}
		// TODO Auto-generated method stub
		return ccdTestConfigResponseList;
	}

	@Override
	public CcdTestData GetMaxDeltaValue(AvgTestData avgTestData, ArrayList<CcdTestData> ccdTestDataList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CcdTestPlan GetCcdTestPlanByName(String planName) {
		// fetch test data from database
		CcdTestPlanExample ccdTestPlanExample = new CcdTestPlanExample();
		CcdTestPlanExample.Criteria exampleCriteria = ccdTestPlanExample.createCriteria();
		exampleCriteria.andPlanNameEqualTo(planName);
		ArrayList<CcdTestPlan> ccdTestPlanList = ccdTestPlanMapper.selectByExample(ccdTestPlanExample);

		// fetch threshold value from testplan.
		if (ccdTestPlanList.isEmpty()) {
			return null;
		} else {
			CcdTestPlan ccdTestPlan = ccdTestPlanList.get(0);
			return ccdTestPlan;
		}
	}

	@Override
	public CcdTestPlan GetCcdTestPlanById(Integer planId) {
		// fetch test data from database
		CcdTestPlan ccdTestPlan = ccdTestPlanMapper.selectByPrimaryKey(planId);
		return ccdTestPlan;
	}

	@Override
	public CcdTestResault GetTestResault(String planName) throws Exception {

		ArrayList<CcdTestData> ccdTestDataList = GetAllTestData(planName);
		Double maxBri = GetMaxBri(ccdTestDataList);
		ArrayList<CcdTestData> effectiveTestDataList = GetEffectiveTestData(planName, ccdTestDataList, maxBri);
		AvgTestData avgTestData = GetAvg(planName, ccdTestDataList);
		Map<String, Double> ellipticMap = CalculateEllipticVaule(avgTestData);

		CcdTestConfig ccdTestConfig = GetCcdTestConfig(planName);

		List<Double> sdcmResaultList = CalculatePixelPointRang(avgTestData, effectiveTestDataList, ellipticMap,
				ccdTestConfig);

		CcdTestResault ccdTestResault = new CcdTestResault();
		ccdTestResault.setPlanName(planName);
		ccdTestResault.setMaxBri(maxBri);
		ccdTestResault.setAvgBri(avgTestData.getAvgBri());
		ccdTestResault.setAvgX(avgTestData.getAvgX());
		ccdTestResault.setAvgY(avgTestData.getAvgY());
		ccdTestResault.setAvgU(avgTestData.getAvgU());
		ccdTestResault.setAvgV(avgTestData.getAvgV());
		ccdTestResault.setAvgDeltaUV(avgTestData.getAvgDeltaUV());
		ccdTestResault.setMaxDeltaUV(avgTestData.getMaxDeltaUV());
		ccdTestResault.setSdcm1Resault(sdcmResaultList.get(0));
		ccdTestResault.setSdcm2Resault(sdcmResaultList.get(1));
		ccdTestResault.setSdcm3Resault(sdcmResaultList.get(2));
		ccdTestResault.setSdcm4Resault(sdcmResaultList.get(3));
		ccdTestResault.setSdcm5Resault(sdcmResaultList.get(4));
		return ccdTestResault;
	}

	@Override
	public CcdTestData[][] convertCcdTesgDataListToArray(String planName, ArrayList<CcdTestData> ccdTestDataList) {
		CcdTestPlan ccdTestPlan = GetCcdTestPlanByName(planName);
		Integer lenX = ccdTestPlan.getPixelX();
		Integer lenY = ccdTestPlan.getPixelY();
		CcdTestData aaa = new CcdTestData();
		CcdTestData[][] ccdTestDataArray = new CcdTestData[lenX][lenY];
		for (int i = 0; i < lenX; i++) {
			List<CcdTestData> tmpList = ccdTestDataList.subList(i * lenY, (i + 1) * lenY);
			for (int j = 0; j < lenY; j++) {
				ccdTestDataArray[i][j] = tmpList.get(j);
			}
		}
		// TODO Auto-generated method stub
		return ccdTestDataArray;
	}

	@Override
	public String DeleteTestData(String planName) throws Exception {
		CcdTestPlan ccdTestPlan = GetCcdTestPlanByName(planName);

		CcdTestDataExample ccdTestDataExample = new CcdTestDataExample();
		CcdTestDataExample.Criteria DataCriteria = ccdTestDataExample.createCriteria();
		DataCriteria.andPlanNameEqualTo(planName);
		this.ccdTestDataMapper.deleteByExample(ccdTestDataExample);

		CcdTestConfigExample ccdTestConfigExample = new CcdTestConfigExample();
		CcdTestConfigExample.Criteria ConfigCriteria = ccdTestConfigExample.createCriteria();
		ConfigCriteria.andPlanidEqualTo(ccdTestPlan.getId());
		this.ccdTestConfigMapper.deleteByExample(ccdTestConfigExample);

		CcdTestRuleExample ccdTestRuleExample = new CcdTestRuleExample();
		CcdTestRuleExample.Criteria RuleCriteria = ccdTestRuleExample.createCriteria();
		RuleCriteria.andPlanidEqualTo(ccdTestPlan.getId());
		this.ccdTestRuleMapper.deleteByExample(ccdTestRuleExample);

		this.ccdTestPlanMapper.deleteByPrimaryKey(ccdTestPlan.getId());

		return "success";
	}
}
