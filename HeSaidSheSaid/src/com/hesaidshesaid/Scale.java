package com.hesaidshesaid;

import android.view.View;
 import android.view.ViewGroup;
 import android.widget.TextView;
 
 public class Scale 
 {
 // Scales the contents of the given view so that it completely fills the given
// container on one axis (that is, we're scaling isotropically).
public static void scaleContents(View rootView, View container)
 {
 // Compute the scaling ratio
 float xScale = (float)container.getWidth() / rootView.getWidth();
 float yScale = (float)container.getHeight() / rootView.getHeight();
 float scale = Math.min(xScale, yScale);

 // Scale our contents
 scaleViewAndChildren(rootView, scale);
 }
// Scale the given view, its contents, and all of its children by the given factor.
public static void scaleViewAndChildren(View root, float scale)
 {
 // Retrieve the view's layout information
 ViewGroup.LayoutParams layoutParams = root.getLayoutParams();
 // Scale the view itself
 if (layoutParams.width != ViewGroup.LayoutParams.FILL_PARENT &&
 layoutParams.width != ViewGroup.LayoutParams.WRAP_CONTENT)
 {
 layoutParams.width *= scale;
 }
 if (layoutParams.height != ViewGroup.LayoutParams.FILL_PARENT &&
 layoutParams.height != ViewGroup.LayoutParams.WRAP_CONTENT)
 {
 layoutParams.height *= scale;
 }

 // If this view has margins, scale those too
 if (layoutParams instanceof ViewGroup.MarginLayoutParams)
 {
 ViewGroup.MarginLayoutParams marginParams =
(ViewGroup.MarginLayoutParams)layoutParams;
 marginParams.leftMargin *= scale;
 marginParams.rightMargin *= scale;
 marginParams.topMargin *= scale;
 marginParams.bottomMargin *= scale;
 }

 // Set the layout information back into the view
 root.setLayoutParams(layoutParams); 
 }
}