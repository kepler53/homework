package News;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.parser.Parser;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DAODOMImpl { // NewsDomParser

	List<News> nList = new ArrayList<News>();

	public List<News> getNewsList(String url) {
		DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder parser = f.newDocumentBuilder();
			Document dom = parser.parse(new URL(url).openConnection().getInputStream());
			Element root = dom.getDocumentElement(); // 최상위 태그 찾아야함 tree의 rootNode
			NodeList dataNodes = root.getElementsByTagName("item");

			for (int i = 0; i < dataNodes.getLength(); i++) {
				News news = new News();
				Node data = dataNodes.item(i);

				NodeList dataChilds = data.getChildNodes();
				for (int j = 0; j < dataChilds.getLength(); j++) {
					Node child = dataChilds.item(j);
					String tname = child.getNodeName();

					if (tname.equals("title")) {
						news.setTitle(child.getFirstChild().getNodeValue());
					}else if(tname.equals("description")){
						news.setDesc(child.getFirstChild().getNodeValue());
					}else if(tname.equals("link")) {
						news.setLink(child.getFirstChild().getNodeValue());
					}
				}
				nList.add(news);
			}
		} catch (Exception e) {
			System.out.println("dom parser error");
			e.printStackTrace();
		}
		return nList;
	}
	//이부분에서 search(i) 한 다음에  listSelectedListner에 어떻게 추가하지?
	
	public News search(int index) {	
		News selectedNews = nList.get(index);
		return selectedNews;	
	}
	
	private void connectNews(String url) {
		
	} 
	//어디 쓰이는 함수인지 모르겠음

}
