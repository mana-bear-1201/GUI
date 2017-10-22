import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class SwingNum implements ActionListener {

		private JFrame mainFrame;
		private Container contentPane;
		private JTextField txtNull;
		private JTextArea textArea;
		private JScrollPane scrollPane;
		private JPanel buttonPane;
		private JButton clearButton;
		private JLabel rule;

		int random;//ランダムで生成された数値（正解）
		int num;//ユーザーに入力される数値
		int count;//入力回数

	public SwingNum(){
		    mainFrame = new JFrame("Numbers-数当てゲーム-");//タイトル
		    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//ゲーム終了
		    mainFrame.setSize(420, 280);//ウィンドウサイズ指定
		    mainFrame.setLocationRelativeTo(null);//配置（Windowsの中央に）

		    contentPane = mainFrame.getContentPane();//コンポーネント（土台）を配置

		    textArea = new JTextArea();//テキストエリア
		    textArea.setBackground(Color.WHITE);//背景色
		    textArea.setToolTipText("ここで答え合わせ実行");
		    textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
		    textArea.setFocusable(false);//書き込み削除禁止！表示のみ
		    scrollPane = new JScrollPane(textArea);//スクロールする

		    clearButton = new JButton("やり直す");
		    clearButton.setFont(new Font("Monospaced", Font.PLAIN, 12));
		    clearButton.addActionListener(this);//アクションリスナー登録

		    rule = new JLabel("<html>コンピューターがランダムで生成した0から100までの数字を当てて下さい<br>ヒントを出します<br>チャンスは10回です");
		    rule.setFont(new Font("Monospaced", Font.PLAIN, 11));
		    rule.setHorizontalAlignment(SwingConstants.CENTER);

		    buttonPane = new JPanel();

		    txtNull = new JTextField();
		    txtNull.setText("数字を入れて下さい");
		    txtNull.setFont(new Font("Monospaced", Font.PLAIN, 12));
		    txtNull.addActionListener(this);//アクションリスナー登録

		    buttonPane.add(txtNull);

		    buttonPane.add(clearButton);
		    contentPane.add(scrollPane, BorderLayout.CENTER);

		    scrollPane.setColumnHeaderView(rule);
		    contentPane.add(buttonPane, BorderLayout.SOUTH);

			reset();//初期化処理

		    mainFrame.setVisible(true);//フレームで表示
	}

	 //答え合わせ処理
	public void check() {
			if (count == 11) {
				textArea.append("ゲームオーバー！" + "\n");
				textArea.append("正解は" + random + "でした" + "\n");
				reset();
			}else{
				if (random == num){
		    		textArea.append(count + "回目：hit!!!正解です。貴方の勝利です" + "\n");
		    		textArea.append("初期化します…" + "\n");
		    		reset();
				}else if (random < num) {
					textArea.append(count + "回目:大きいです" + "\n");//ヒント・大
				}else{
					textArea.append(count + "回目:小さいです" + "\n");//ヒント・小
				}
			}
	}

	//初期化（変数）処理
	public void reset() {
			random = new java.util.Random().nextInt(101);//100まで
	        num = 0;
	        count = 0;
	}

	//初期化（テキスト）処理
	public void reset_t() {
	    	txtNull.setText("数字を入れて下さい");
	    	textArea.setText(null);
	}

	// アクション処理
	public void actionPerformed(ActionEvent e){
	        if(e.getSource() == txtNull){
	        		num = Integer.parseInt(txtNull.getText());
	    		try {
	    			count++;//カウントする
					check();//答え合わせ処理呼び出し
				} catch (Exception e1) {
					e1.printStackTrace();//エラー処理
				}
	        }
	        if(e.getSource() == clearButton) {//初期化処理
	        	reset();
	        	reset_t();
	        }
	}

	 // アプリケーションの起動
	public static void main(String[] args) {
	            new SwingNum();
	}

}