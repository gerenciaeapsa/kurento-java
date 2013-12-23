/*
 * (C) Copyright 2013 Kurento (http://kurento.org/)
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser General Public License
 * (LGPL) version 2.1 which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl-2.1.html
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 */
package com.kurento.demo.webrtc;

import com.kurento.kmf.content.WebRtcContentHandler;
import com.kurento.kmf.content.WebRtcContentService;
import com.kurento.kmf.content.WebRtcContentSession;
import com.kurento.kmf.media.MediaElement;
import com.kurento.kmf.media.MediaPipeline;

/**
 * WebRtc Handler in loopback.
 * 
 * @author Boni García (bgarcia@gsyc.es)
 * @version 1.0.0
 */
@WebRtcContentService(path = "/webRtcLoopback")
public class WebRtcLoopback extends WebRtcContentHandler {

	@Override
	public void onContentRequest(WebRtcContentSession session) throws Exception {
		MediaPipeline mp = session.getMediaPipelineFactory().create();
		session.releaseOnTerminate(mp);
		session.start(null, (MediaElement) null);
	}

}