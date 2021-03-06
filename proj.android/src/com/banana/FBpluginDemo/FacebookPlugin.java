/****************************************************************************
Copyright (c) 2010-2011 cocos2d-x.org

http://www.cocos2d-x.org

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
****************************************************************************/
package com.banana.FBpluginDemo;

import org.cocos2dx.lib.Cocos2dxActivity;
import org.cocos2dx.lib.Cocos2dxGLSurfaceView;
import org.FBPlugin.*;

import com.facebook.AppEventsLogger;

import android.content.Intent;
import android.os.Bundle;

public class FacebookPlugin extends Cocos2dxActivity{
	
	protected FacebookConnectPlugin facebookLoginPlugin = null;
	protected FacebookPostPlugin facebookPostPlugin = null;
	protected FacebookSendRequestsPlugin facebookSendRequestsPlugin = null;	
	
    protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);	
		facebookLoginPlugin = new FacebookConnectPlugin(this);
		facebookPostPlugin = new FacebookPostPlugin(this);
		facebookSendRequestsPlugin = new FacebookSendRequestsPlugin(this);
		facebookLoginPlugin.onCreate(savedInstanceState);
		facebookPostPlugin.onCreate(savedInstanceState);
		facebookSendRequestsPlugin.onCreate(savedInstanceState);
	}

    public Cocos2dxGLSurfaceView onCreateView() {
    	Cocos2dxGLSurfaceView glSurfaceView = new Cocos2dxGLSurfaceView(this);
    	// FacebookPlugin should create stencil buffer
    	glSurfaceView.setEGLConfigChooser(5, 6, 5, 0, 16, 8);
    	
    	return glSurfaceView;
    }

    @Override
    protected void onResume() {
      super.onResume();

      // Logs 'install' and 'app activate' App Events.
      AppEventsLogger.activateApp(this);
      facebookLoginPlugin.onResume();
      facebookPostPlugin.onResume();
      facebookSendRequestsPlugin.onResume();
    }

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		facebookLoginPlugin.onActivityResult(requestCode, resultCode, data);
		facebookPostPlugin.onActivityResult(requestCode, resultCode, data);
		facebookSendRequestsPlugin.onActivityResult(requestCode, resultCode, data);
	}
    
    @Override
    protected void onPause() {
      super.onPause();

      // Logs 'app deactivate' App Event.
      AppEventsLogger.deactivateApp(this);
      facebookLoginPlugin.onPause();
      facebookPostPlugin.onPause();
      facebookSendRequestsPlugin.onPause();
    }
    
	@Override
	public void onDestroy() {
		super.onDestroy();
		facebookLoginPlugin.onDestory();
		facebookPostPlugin.onDestory();
		facebookSendRequestsPlugin.onDestory();
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		facebookLoginPlugin.onSaveInstanceState(outState);
		facebookPostPlugin.onSaveInstanceState(outState);
		facebookSendRequestsPlugin.onSaveInstanceState(outState);
	}
    
    static {
        System.loadLibrary("cocos2dcpp");
    }     
}
