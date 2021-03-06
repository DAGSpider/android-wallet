package io.xdag.common.base;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import butterknife.ButterKnife;
import io.xdag.common.Common;
import io.xdag.common.R;
import io.xdag.common.tool.ToolbarMode;

/**
 * created by lxm on 2018/5/24.
 * <p>
 * desc : The activity with Toolbar
 */
public abstract class ToolbarActivity extends BaseActivity {

    protected Toolbar mToolbar;


    @Override
    public void setContentView(View view) {
        LinearLayout rootLayout =
                (LinearLayout) View.inflate(mContext, R.layout.layout_toolbar, null);
        super.setContentView(rootLayout);
        rootLayout.addView(view, ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        if (!(this instanceof RefreshActivity)) {
            ButterKnife.bind(this);
        }
        mToolbar = rootLayout.findViewById(R.id.toolbar);
        initToolbar();
    }


    protected void initToolbar() {
        mToolbar.setTitle(getToolbarTitle());
        mToolbar.setTitleTextColor(Common.getColor(R.color.WHITE));
        switch (getToolbarMode()) {
            case ToolbarMode.MODE_BACK:
                mToolbar.setNavigationIcon(R.drawable.ic_back);
                break;
            default:
        }

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (getToolbarMode()) {
                    case ToolbarMode.MODE_BACK:
                        onBackPressed();
                        break;
                    default:

                }
            }
        });
    }


    protected int getToolbarMode() {
        return ToolbarMode.MODE_BACK;
    }


    protected int getToolbarTitle() {
        return R.string.empty;
    }


    public Toolbar getToolbar() {
        return mToolbar;
    }
}
