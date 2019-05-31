package xml.document;

import com.tianhaolin.myioc.xml.document.XmlDocumentHolder;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

/**
 * @author:tianhaolin
 * @version:1.0
 */
public class XmlDocumentHolderTest {
    private XmlDocumentHolder xmlHolder;

    @Before
    public void setUp() throws Exception {
        xmlHolder = new XmlDocumentHolder();
    }

    @After
    public void tearDown() throws Exception {
        xmlHolder = null;
    }

    //测试正常情况
    @Test
    public void testGetDocument1() {
        String filePath = this.getClass().getResource("/document/documentHolder.xml").getPath();
        //获得Document对象
        Document doc1 = xmlHolder.getDocument(filePath);
        //看是否为空，为空测试失败
        assertNotNull(doc1);
        //得到xml文档根元素
        Element root = doc1.getRootElement();
        //判断根元素是否为beans，不是beans测试失败
        assertEquals(root.getName(), "beans");
        //再获取一次Document对象，看是否一致
        Document doc2 = xmlHolder.getDocument(filePath);
        System.out.println(doc1);
        System.out.println(doc1);
        assertEquals(doc1, doc2);
    }
}

