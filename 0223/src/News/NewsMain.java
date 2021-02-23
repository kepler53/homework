package News;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class NewsMain {
    JFrame f;
    JButton b;
    JList<News> li;
    JTextArea ta;
    DAODOMImpl dao;
    News[] tmp;
    

    
    public NewsMain() {
        dao = new DAODOMImpl();
        createGUI();
        addEvent();
        showList();
    }


    public void createGUI() {
        f = new JFrame("NewsList");
        JPanel p = new JPanel();
        b = new JButton("News List 호출");
        li = new JList();
        ta = new JTextArea("");
        ta.setLineWrap(true);
        p.setLayout(new BorderLayout());
        p.add(b,"North");
        p.add(li);
        f.setLayout(new GridLayout(2,1,5,5));
        f.add(p);
        f.add(ta);
        f.setSize(400,500);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void addEvent() {
//        f.addWindowStateListener(new WindowAdapter(){
//            public void windowsClosing(WindowEvent e) { System.exit(0);}
//        });
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showList();
            }
        });
        li.addListSelectionListener(listener);
    }

    public void showList() {
        java.util.List<News> datas = dao.getNewsList("http://rss.etnews.com/Section902.xml");
        li.removeListSelectionListener(listener); 
        li.removeAll();
        tmp = new News[datas.size()];
        li.setListData(datas.toArray(tmp)); //이부분까지가 제목 타이틀 구현한 부분
        li.addListSelectionListener(listener); //이부분도 listselection하는 부분
    }
    
    ListSelectionListener listener = new ListSelectionListener() {
        public void valueChanged(ListSelectionEvent arg0) {
            News n = (News)li.getSelectedValue();
            ta.setText(n.getDesc());
        }
    };
    
    public static void main(String[] args) {
        new NewsMain();
    }

}