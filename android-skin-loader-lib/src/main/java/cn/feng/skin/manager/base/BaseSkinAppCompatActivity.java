package cn.feng.skin.manager.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Field;
import java.util.List;

import cn.feng.skin.manager.entity.DynamicAttr;
import cn.feng.skin.manager.listener.IDynamicNewView;
import cn.feng.skin.manager.listener.ISkinUpdate;
import cn.feng.skin.manager.loader.SkinInflaterFactory2;
import cn.feng.skin.manager.loader.SkinManager;

/**
 * Base AppCompat Activity for development
 * 
 * <p>NOTICE:<br> 
 * You should extends from this if you want to do skin change
 * 
 * @author fengjun
 */
public class BaseSkinAppCompatActivity extends AppCompatActivity implements ISkinUpdate, IDynamicNewView{
	
	/**
	 * Whether response to skin changing after create
	 */
	private boolean isResponseOnSkinChanging = true;
	
	private SkinInflaterFactory2 mSkinInflaterFactory2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
        try {
            Field field = LayoutInflater.class.getDeclaredField("mFactorySet");
            field.setAccessible(true);
            field.setBoolean(getLayoutInflater(), false);
            
    		mSkinInflaterFactory2 = new SkinInflaterFactory2(this);
    		getLayoutInflater().setFactory2(mSkinInflaterFactory2);

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

		super.onCreate(savedInstanceState);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		SkinManager.getInstance().attach(this);
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		SkinManager.getInstance().detach(this);
		mSkinInflaterFactory2.mActivity = null;
	}
	
	protected void dynamicAddSkinEnableView(View view, String attrName, int attrValueResId){	
		mSkinInflaterFactory2.dynamicAddSkinEnableView(this, view, attrName, attrValueResId);
	}
	
	protected void dynamicAddSkinEnableView(View view, List<DynamicAttr> pDAttrs){	
		mSkinInflaterFactory2.dynamicAddSkinEnableView(this, view, pDAttrs);
	}
	
	final protected void enableResponseOnSkinChanging(boolean enable){
		isResponseOnSkinChanging = enable;
	}

	@Override
	public void onThemeUpdate() {
		if(!isResponseOnSkinChanging) return;
		mSkinInflaterFactory2.applySkin();
	}
	
	@Override
	public void dynamicAddView(View view, List<DynamicAttr> pDAttrs) {
		mSkinInflaterFactory2.dynamicAddSkinEnableView(this, view, pDAttrs);
	}
}
