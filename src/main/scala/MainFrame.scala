/**
 * Created by FScoward on 2014/09/22.
 */
import javax.swing.JFrame
import javax.imageio.ImageIO
import java.io.File
import java.awt.{SystemTray, TrayIcon, PopupMenu, MenuItem}
import java.awt.event.{ActionEvent, ActionListener, WindowAdapter, WindowEvent}

class MainFrame extends JFrame {

  /**
   * 終了時のアクションリスナー
   * */
  val exitActionListener = new ActionListener() {
    def actionPerformed(e: ActionEvent) = {
      println("pushed")
      sys.exit(0)
    }
  }

  /**
   * 設定
   * */
  def init = {

    setVisible(true)
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
    setSize(300, 300)

    createSystemTray

    addWindowListener(new WindowAdapter() {
      override def windowClosing(e: WindowEvent) = {
        println("window closing")
        sys.exit(0)
      }
    })
  }

  /**
   * システムトレイ生成
   * */
  def createSystemTray = {
    val systemTray = SystemTray.getSystemTray

    val poupMenu = new PopupMenu("Foreboding")
    val exitMenuItem = new MenuItem("Exit")
    poupMenu.add(exitMenuItem)
    exitMenuItem.addActionListener(exitActionListener)

    val trayIcon = new TrayIcon(ImageIO.read(new File("src/main/resources/035.png")), "", poupMenu)
    systemTray.add(trayIcon)
  }
}
