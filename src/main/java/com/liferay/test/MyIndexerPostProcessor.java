package com.liferay.test;

import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerPostProcessor;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.service.UserLocalService;

import java.util.Locale;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;

/**
 * @author peterpetrekanics
 */
@Component(
		immediate = true,
		property = {
				"indexer.class.name=com.liferay.portal.kernel.model.User",
				},
		service = IndexerPostProcessor.class)

public class MyIndexerPostProcessor implements IndexerPostProcessor {

	@Override
	public void postProcessContextBooleanFilter(BooleanFilter arg0, SearchContext arg1) throws Exception {
		// TODO Auto-generated method stub
//		System.out.println("postProcessContextBooleanFilter1");
//		if (_log.isInfoEnabled()) {
//			_log.info("postProcessContextBooleanFilter2");
//		} else {
//			System.out.println("mytest1");
//		}
	}

	@Override
	public void postProcessContextQuery(BooleanQuery arg0, SearchContext arg1) throws Exception {
		// TODO Auto-generated method stub
//		System.out.println("postProcessContextQuery1");
//		_log.info("postProcessContextQuery2");

	}

	@Override
	public void postProcessDocument(Document document, Object object) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("postProcessDocument starts");
//		_log.info("postProcessDocument2");

		User userEntity = (User) object;
		String indexerUserTitle = "";
		try {
			indexerUserTitle = userEntity.getJobTitle();
		} catch (Exception e) {
		}
		if (indexerUserTitle.length() > 0)
			document.addText(Field.TITLE, indexerUserTitle);

		System.out.println("postProcessDocument ends");
	}

	@Override
	public void postProcessFullQuery(BooleanQuery arg0, SearchContext arg1) throws Exception {
		// TODO Auto-generated method stub
//		System.out.println("postProcessFullQuery1");
//		_log.info("postProcessFullQuery2");

	}

	@Override
	public void postProcessSearchQuery(BooleanQuery arg0, SearchContext arg1) throws Exception {
		// TODO Auto-generated method stub
//		System.out.println("postProcessSearchQuery1");
//		_log.info("postProcessSearchQuery2");

	}

	@Override
	public void postProcessSearchQuery(BooleanQuery arg0, BooleanFilter arg1, SearchContext arg2) throws Exception {
		// TODO Auto-generated method stub
//		System.out.println("postProcessSearchQuery1");
//		_log.info("postProcessSearchQuery2");

	}

	@Override
	public void postProcessSummary(Summary arg0, Document arg1, Locale arg2, String arg3) {
		// TODO Auto-generated method stub
//		System.out.println("postProcessSummary1");
//		_log.info("postProcessSummary2");

	}

	// TODO enter required service methods

	private static final Log _log = LogFactoryUtil.getLog(MyIndexerPostProcessor.class);

	// @Reference(
	// target = "(indexer.class.name=com.liferay.portal.kernel.model.User)"
	// )

	@Reference(unbind = "-")
	protected void setUserLocalService(UserLocalService userLocalService) {

		_userLocalService = userLocalService;
	}

	protected Indexer indexer;
	private UserLocalService _userLocalService;

}