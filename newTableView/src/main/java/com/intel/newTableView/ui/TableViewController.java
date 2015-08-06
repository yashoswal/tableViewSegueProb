package com.intel.newTableView.ui;

import com.intel.inde.moe.natj.general.NatJ;
import com.intel.inde.moe.natj.general.Pointer;
import com.intel.inde.moe.natj.general.ann.Generated;
import com.intel.inde.moe.natj.general.ann.NInt;
import com.intel.inde.moe.natj.general.ann.Owned;
import com.intel.inde.moe.natj.general.ann.RegisterOnStartup;
import com.intel.inde.moe.natj.objc.ann.ObjCClassName;
import com.intel.inde.moe.natj.objc.ann.Property;
import com.intel.inde.moe.natj.objc.ann.Selector;

import java.io.InputStream;

import ios.foundation.NSIndexPath;
import ios.uikit.UIStoryboardSegue;
import ios.uikit.UITableView;
import ios.uikit.UITableViewCell;
import ios.uikit.UITableViewController;

/**
 * Created by ymoswal on 8/5/15.
 */
@ObjCClassName("TableViewController")
@RegisterOnStartup
public class TableViewController extends UITableViewController {
    CourseData cd1;
    CourseData cd2;

    static {
        NatJ.register();
    }

    @Generated("NatJ")
    @Owned
    @Selector("alloc")
    public static native TableViewController alloc();

    @Generated("NatJ")
    @Selector("init")
    public native TableViewController init();

    @Generated
    protected TableViewController(Pointer peer) {
        super(peer);
    }

    @Property
    @Selector("theCell")
    public native UITableViewCell getTheCell();

    @Property
    @Selector("tableList")
    public native UITableView getTableList();

    @Override
    @Selector("viewDidLoad")
    public void viewDidLoad() {

        InputStream ios_stream = null;
        InputStream web_stream = null;
        try {
            ClassLoader cl = ClassLoader.getSystemClassLoader();
            ios_stream = cl.getResourceAsStream("courses.txt");
            web_stream = cl.getResourceAsStream("courses_web.txt");
            cd1 = new CourseData(ios_stream);
            cd2 = new CourseData(web_stream);
        }
        catch(Exception e) {

        }

    }

    @NInt
    @Selector("numberOfSectionsInTableView:")
    public long numberOfSectionsInTableView(UITableView tableView){
        return 2;
    }

    @NInt
    @Selector("tableView:numberOfRowsInSection:")
    public long tableViewNumberOfRowsInSection(UITableView tableView, @NInt long section){
        if(section==0) {
            return cd1.getSize();
        }
        else {
            return cd2.getSize();
        }
    }

    @Selector("tableView:cellForRowAtIndexPath:")
    public UITableViewCell tableViewCellForRowAtIndexPath(UITableView tableView, NSIndexPath indexPath){

        Long index = indexPath.row();

        UITableViewCell cell = UITableViewCell.alloc().init();
        if (indexPath.section() == 0) {
            cell.textLabel().setText(cd1.getCourse(index.intValue()));
            return cell;
        } else {
            cell.textLabel().setText(cd2.getCourse(index.intValue()));
            return cell;
        }
    }

    @Selector("shouldPerformSegueWithIdentifier:sender:")
    @Override
    public boolean shouldPerformSegueWithIdentifierSender(String s, Object o) {
        if (s.equals("showDetails")) {
            return true;
        }
        else {
            return false;
        }
    }

    @Selector("prepareForSegue:sender:")
    @Override
    public void prepareForSegueSender(UIStoryboardSegue segue, Object sender) {
        System.out.println("In prepare for segue ");
        if(segue.identifier().equals("showDetails")) {
            UITableViewCell cell = (UITableViewCell) sender;
            long path = tableView().indexPathForCell(cell).row();
            long section = tableView().indexPathForCell(cell).section();
            if (section == 0) {

                Long index = path;
                DetailViewController dest = (DetailViewController) segue.destinationViewController();
           /* dest.setCourse(cd1.getCourse(index.intValue()));
            dest.setAuthor(cd1.getAuthor(index.intValue()));
            dest.setDescription(cd1.getDescription(index.intValue()));*/
            }
            if (section == 1) {
                System.out.println("In prepare for segue ");
                Long index = path;
                DetailViewController dest = (DetailViewController) segue.destinationViewController();
            /*dest.setCourse(cd2.getCourse(index.intValue()));
            dest.setAuthor(cd2.getAuthor(index.intValue()));
            dest.setDescription(cd2.getDescription(index.intValue()));*/

            }
        }
    }


    @Selector("tableView:titleForHeaderInSection:")
    @Override
    public String tableViewTitleForHeaderInSection(UITableView tableView, @NInt long section){

        if(section == 0){
            return "ios Courses";
        }
        else{
            return "web courses";
        }
    }

}
