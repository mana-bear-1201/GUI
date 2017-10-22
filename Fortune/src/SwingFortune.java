import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SwingFortune implements ActionListener {

		private JFrame mainFrame;
		private JLabel label;
		private ImageIcon icon;
		private JPanel panel;
		private JButton button;
		private JButton button_1;

		int random;

	public SwingFortune(){
	        mainFrame = new JFrame("おみくじ");//タイトル
	        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//ゲーム終了
	        mainFrame.setSize(310, 500);//ウィンドウサイズ指定
	        mainFrame.setLocationRelativeTo(null);//配置（Windowsの中央に）
	        mainFrame.setResizable(false);//ウィンドウサイズ固定

	        icon = new ImageIcon(getClass().getResource("img/omikuji.png"));
	        label = new JLabel(icon);//ラベルに画像を表示する

	        panel = new JPanel();

	        button = new JButton("おみくじをひく");
	        button.addActionListener(this);//アクションリスナー

	        button_1 = new JButton("　おわる　");
	        button_1.addActionListener(this);//アクションリスナー

	        panel.setLayout(new FlowLayout(FlowLayout.CENTER));

	        panel.add(label);//パネルにラベルを乗せる
	        panel.add(button);//パネルにボタンを乗せる(おみくじ）
	        panel.add(button_1);//パネルにボタンを乗せる（終了）

	        mainFrame.getContentPane().add(panel);

	        mainFrame.setVisible(true);//フレームで表示

	        random() ;//乱数生成処理
	}

		/*
			おみくじの確率
			大吉22% 0-21
			吉28% 22-48
			中吉8% 50-57
			小吉13% 57-69
			末吉15% 70-85
			凶13% 86-99
			大凶1% 100
		 */

	//乱数生成処理
	public void random() {
			random = new java.util.Random().nextInt(101);//100まで
	}

	//分岐処理
	public void fortune() {
		   //大吉
		   if (random <= 21) {
		    label.setIcon(new ImageIcon(getClass().getResource("img/1.png")));
		    //吉
		    }else if (random <= 48 ) {
		    label.setIcon(new ImageIcon(getClass().getResource("img/2.png")));
		    //中吉
		    }else if (random <= 57 ){
		    label.setIcon(new ImageIcon(getClass().getResource("img/3.png")));
		    //小吉
		    }else if (random <= 69 ){
		    label.setIcon(new ImageIcon(getClass().getResource("img/4.png")));
		    //末吉
		    }else if (random <= 85 ){
		    label.setIcon(new ImageIcon(getClass().getResource("img/5.png")));
		    //凶
		    }else if (random <= 99 ){
		    label.setIcon(new ImageIcon(getClass().getResource("img/6.png")));
		    //大凶
		    }else{
		    label.setIcon(new ImageIcon(getClass().getResource("img/7.png")));
		    }
	}

	//アクションリスナー
	public void actionPerformed(ActionEvent e) {
			if (e.getSource() == button) {
				fortune();//分岐処理呼び出し
		    }
	        if (e.getSource() == button_1) {
	        	System.exit(0);//終了する
			}
	}

	// アプリケーションの起動
	public static void main(String[] args) {
			new SwingFortune();
	}

}