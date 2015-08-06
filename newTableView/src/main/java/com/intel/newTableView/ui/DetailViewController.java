package com.intel.newTableView.ui;

import com.intel.inde.moe.natj.general.NatJ;
import com.intel.inde.moe.natj.general.Pointer;
import com.intel.inde.moe.natj.general.ann.Generated;
import com.intel.inde.moe.natj.general.ann.Owned;
import com.intel.inde.moe.natj.objc.ann.Selector;

import ios.uikit.UIViewController;

/**
 * Created by ymoswal on 8/5/15.
 */
public class DetailViewController extends UIViewController{
    static {
        NatJ.register();
    }

    @Generated("NatJ")
    @Owned
    @Selector("alloc")
    public static native DetailViewController alloc();

    @Generated("NatJ")
    @Selector("init")
    public native DetailViewController init();

    @Generated
    protected DetailViewController(Pointer peer) {
        super(peer);
    }
}
