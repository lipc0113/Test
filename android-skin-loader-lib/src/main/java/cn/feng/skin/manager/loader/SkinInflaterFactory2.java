package cn.feng.skin.manager.loader;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewParent;

import androidx.appcompat.widget.VectorEnabledTintResources;
import androidx.core.view.ViewCompat;

import com.example.android_skin_loader_lib.R;

import org.xmlpull.v1.XmlPullParser;

import java.util.ArrayList;
import java.util.List;

import cn.feng.skin.manager.config.SkinConfig;
import cn.feng.skin.manager.entity.AttrFactory;
import cn.feng.skin.manager.entity.DynamicAttr;
import cn.feng.skin.manager.entity.SkinAttr;
import cn.feng.skin.manager.entity.SkinItem;
import cn.feng.skin.manager.util.L;
import cn.feng.skin.manager.util.ListUtils;

/**
 * Supply {@link SkinInflaterFactory2} to be called when inflating from a LayoutInflater.
 * 
 * <p>Use this to collect the {skin:enable="true|false"} views availabled in our XML layout files.
 * 
 * @author fengjun
 */
public class SkinInflaterFactory2 implements LayoutInflater.Factory2 {
	
	private static final boolean DEBUG = true;

	private static final String TAG = "SkinInflaterFactory2";
	private static final boolean IS_PRE_LOLLIPOP = Build.VERSION.SDK_INT < 21;

	/**
	 * Store the view item that need skin changing in the activity
	 */
	private List<SkinItem> mSkinItems = new ArrayList<SkinItem>();
	private AppCompatViewInflater mAppCompatViewInflater;
	public Activity mActivity;

	public SkinInflaterFactory2(Activity activity) {

		mActivity = activity;
	}

	@Override
	public View onCreateView(String name, Context context, AttributeSet attrs) {

		return null;
	}
	
	/**
     * Invoke low-level function for instantiating a view by name. This attempts to
     * instantiate a view class of the given <var>name</var> found in this
     * LayoutInflater's ClassLoader.
     * 
     * @param context 
     * @param name The full name of the class to be instantiated.
     * @param attrs The XML attributes supplied for this instance.
     * 
     * @return View The newly instantiated view, or null.
     */
	private View createView(Context context, String name, AttributeSet attrs) {
		View view = null;
		try {
			if (-1 == name.indexOf('.')){
				if ("View".equals(name)) {
					view = LayoutInflater.from(context).createView(name, "android.view.", attrs);
				} 
				if (view == null) {
					view = LayoutInflater.from(context).createView(name, "android.widget.", attrs);
				} 
				if (view == null) {
					view = LayoutInflater.from(context).createView(name, "android.webkit.", attrs);
				} 
			}else {
	            view = LayoutInflater.from(context).createView(name, null, attrs);
	        }

			L.i("about to create " + name);

		} catch (Exception e) { 
			L.e("error while create 【" + name + "】 : " + e.getMessage());
			view = null;
		}
		return view;
	}

	/**
	 * Collect skin able tag such as background , textColor and so on
	 * 
	 * @param context
	 * @param attrs
	 * @param view
	 */
	private void parseSkinAttr(Context context, AttributeSet attrs, View view) {
		List<SkinAttr> viewAttrs = new ArrayList<SkinAttr>();
		
		for (int i = 0; i < attrs.getAttributeCount(); i++){
			String attrName = attrs.getAttributeName(i);
			String attrValue = attrs.getAttributeValue(i);
			
			if(!AttrFactory.isSupportedAttr(attrName)){
				continue;
			}
			
		    if(attrValue.startsWith("@")){
				try {
					int id = Integer.parseInt(attrValue.substring(1));
					String entryName = context.getResources().getResourceEntryName(id);
					String typeName = context.getResources().getResourceTypeName(id);
					SkinAttr mSkinAttr = AttrFactory.get(attrName, id, entryName, typeName);
					if (mSkinAttr != null) {
						viewAttrs.add(mSkinAttr);
					}
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (NotFoundException e) {
					e.printStackTrace();
				}
		    }
		}
		
		if(!ListUtils.isEmpty(viewAttrs)){
			SkinItem skinItem = new SkinItem();
			skinItem.view = view;
			skinItem.attrs = viewAttrs;

			mSkinItems.add(skinItem);
			
			if(SkinManager.getInstance().isExternalSkin()){
				skinItem.apply();
			}
		}
	}
	
	public void applySkin(){
		if(ListUtils.isEmpty(mSkinItems)){
			return;
		}
		
		for(SkinItem si : mSkinItems){
			if(si.view == null){
				continue;
			}
			si.apply();
		}
	}
	
	public void dynamicAddSkinEnableView(Context context, View view, List<DynamicAttr> pDAttrs){	
		List<SkinAttr> viewAttrs = new ArrayList<SkinAttr>();
		SkinItem skinItem = new SkinItem();
		skinItem.view = view;
		
		for(DynamicAttr dAttr : pDAttrs){
			int id = dAttr.refResId;
			String entryName = context.getResources().getResourceEntryName(id);
			String typeName = context.getResources().getResourceTypeName(id);
			SkinAttr mSkinAttr = AttrFactory.get(dAttr.attrName, id, entryName, typeName);
			viewAttrs.add(mSkinAttr);
		}
		
		skinItem.attrs = viewAttrs;
		addSkinView(skinItem);
	}
	
	public void dynamicAddSkinEnableView(Context context, View view, String attrName, int attrValueResId){	
		int id = attrValueResId;
		String entryName = context.getResources().getResourceEntryName(id);
		String typeName = context.getResources().getResourceTypeName(id);
		SkinAttr mSkinAttr = AttrFactory.get(attrName, id, entryName, typeName);
		SkinItem skinItem = new SkinItem();
		skinItem.view = view;
		List<SkinAttr> viewAttrs = new ArrayList<SkinAttr>();
		viewAttrs.add(mSkinAttr);
		skinItem.attrs = viewAttrs;
		addSkinView(skinItem);
	}
	
	public void addSkinView(SkinItem item){
		mSkinItems.add(item);
	}
	
	public void clean(){
		if(ListUtils.isEmpty(mSkinItems)){
			return;
		}
		
		for(SkinItem si : mSkinItems){
			if(si.view == null){
				continue;
			}
			si.clean();
		}
	}

	@SuppressLint("RestrictedApi")
	@Override
	public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
		if (mAppCompatViewInflater == null) {
//			TypedArray a = context.obtainStyledAttributes(R.styleable.AppCompatTheme);
//			String viewInflaterClassName =
//					a.getString(R.styleable.AppCompatTheme_viewInflaterClass);
//			if ((viewInflaterClassName == null)
//					|| AppCompatViewInflater.class.getName().equals(viewInflaterClassName)) {
//				// Either default class name or set explicitly to null. In both cases
//				// create the base inflater (no reflection)
//				mAppCompatViewInflater = new AppCompatViewInflater();
//			} else {
//				try {
//					Class viewInflaterClass = Class.forName(viewInflaterClassName);
//					mAppCompatViewInflater =
//							(AppCompatViewInflater) viewInflaterClass.getDeclaredConstructor()
//									.newInstance();
//				} catch (Throwable t) {
//					Log.i(TAG, "Failed to instantiate custom view inflater "
//							+ viewInflaterClassName + ". Falling back to default.", t);
//					mAppCompatViewInflater = new AppCompatViewInflater();
//				}
//			}
			mAppCompatViewInflater = new AppCompatViewInflater();
		}

		boolean inheritContext = false;
		if (IS_PRE_LOLLIPOP) {
			inheritContext = (attrs instanceof XmlPullParser)
					// If we have a XmlPullParser, we can detect where we are in the layout
					? ((XmlPullParser) attrs).getDepth() > 1
					// Otherwise we have to use the old heuristic
					: shouldInheritContext((ViewParent) parent);
		}

		View view = mAppCompatViewInflater.createView(parent, name, context, attrs, inheritContext,
				IS_PRE_LOLLIPOP, /* Only read android:theme pre-L (L+ handles this anyway) */
				true, /* Read read app:theme as a fallback at all times for legacy reasons */
				VectorEnabledTintResources.shouldBeUsed() /* Only tint wrap the context if enabled */
		);

		boolean isSkinEnable = attrs.getAttributeBooleanValue(SkinConfig.NAMESPACE, SkinConfig.ATTR_SKIN_ENABLE, false);
		if (view != null && isSkinEnable){
			parseSkinAttr(context, attrs, view);
		}

		return view;
	}

	private boolean shouldInheritContext(ViewParent parent) {
		if (parent == null) {
			// The initial parent is null so just return false
			return false;
		}
		final View windowDecor = mActivity.getWindow().getDecorView();
		while (true) {
			if (parent == null) {
				// Bingo. We've hit a view which has a null parent before being terminated from
				// the loop. This is (most probably) because it's the root view in an inflation
				// call, therefore we should inherit. This works as the inflated layout is only
				// added to the hierarchy at the end of the inflate() call.
				return true;
			} else if (parent == windowDecor || !(parent instanceof View)
					|| ViewCompat.isAttachedToWindow((View) parent)) {
				// We have either hit the window's decor view, a parent which isn't a View
				// (i.e. ViewRootImpl), or an attached view, so we know that the original parent
				// is currently added to the view hierarchy. This means that it has not be
				// inflated in the current inflate() call and we should not inherit the context.
				return false;
			}
			parent = parent.getParent();
		}
	}
}
