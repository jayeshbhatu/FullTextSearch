package com.product.dao;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.product.domain.Product;

@Transactional
@Repository
public class ProductDaoImpl implements ProductDao{

	@Autowired
	SessionFactory  sessionFactory;
	@Override
	public boolean insertProductDetail(Product objProduct) throws Exception {
		try
		{
		Session session=sessionFactory.getCurrentSession();
		/*FullTextSession fullTextSession = Search.getFullTextSession(session);
		fullTextSession.createIndexer().startAndWait();
		*/session.save(objProduct);
			
		return (Long)session.getIdentifier(objProduct) > 0;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> search(String  searchCategory)  throws Exception{
	try
	{
		List<Product> objProducts=Collections.emptyList();
		@SuppressWarnings("unused")
		Session session=sessionFactory.getCurrentSession();
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Product.class);
		criteria.add(Restrictions.ilike("category", searchCategory,MatchMode.ANYWHERE));
		if(criteria.list().size() > 0)
		{
			objProducts=criteria.list();
			return objProducts;
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return null;
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Product> searchFulltext(String searchText) throws Exception {
	
		 try
	      {
	    	 Session session = sessionFactory.getCurrentSession();
	         FullTextSession fullTextSession = Search.getFullTextSession(session);
	         fullTextSession.createIndexer().startAndWait();
	         QueryBuilder qb = fullTextSession.getSearchFactory()
	           .buildQueryBuilder().forEntity(Product.class).get();
	         org.apache.lucene.search.Query query = qb
	           .keyword().onFields("fullName", "category")
	           .matching(searchText)
	           .createQuery();
	         org.hibernate.Query hibQuery = 
	            fullTextSession.createFullTextQuery(query, Product.class);
	         @SuppressWarnings("unchecked")
			 List<Product> results = hibQuery.list();
	      	   Collections.sort(results ,new Comparator<Product>() {
				@Override
				public int compare(Product o1, Product o2) {
					String fullName=o1.getFullName();
					String fullName1=o2.getFullName();
					Integer comparisoin=o1.compareTo(o2);
					if(comparisoin != 0)
					{
						return comparisoin;
					}
					else
					{
						String category=o1.getCategory();
						String category1=o2.getCategory();
						return category.compareTo(category1);
					}
					
				}
			});
	         
	         return results;
	      }
	      catch(Exception e)
	      {
	         throw e;
	      }
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static void order(List<Product> persons) {

	
}
}