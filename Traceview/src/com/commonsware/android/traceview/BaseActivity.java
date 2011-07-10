/***
	Copyright (c) 2011 CommonsWare, LLC
	Licensed under the Apache License, Version 2.0 (the "License"); you may not
	use this file except in compliance with the License. You may obtain	a copy
	of the License at http://www.apache.org/licenses/LICENSE-2.0. Unless required
	by applicable law or agreed to in writing, software distributed under the
	License is distributed on an "AS IS" BASIS,	WITHOUT	WARRANTIES OR CONDITIONS
	OF ANY KIND, either express or implied. See the License for the specific
	language governing permissions and limitations under the License.
	
	From _Tuning Android Applications_
		http://commonsware.com/AndTuning
*/

	 
package com.commonsware.android.traceview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

abstract public class BaseActivity extends Activity {
	abstract BaseTask createTask(TextView msg, View v);
	TextView msg=null;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.main);
			
			msg=(TextView)findViewById(R.id.message);
	}
	
	public void go(View v) {
		v.setEnabled(false);
		createTask(msg, v).execute();
	}
}