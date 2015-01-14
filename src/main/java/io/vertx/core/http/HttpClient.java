/*
 * Copyright (c) 2011-2013 The original author or authors
 * ------------------------------------------------------
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Apache License v2.0 which accompanies this distribution.
 *
 *     The Eclipse Public License is available at
 *     http://www.eclipse.org/legal/epl-v10.html
 *
 *     The Apache License v2.0 is available at
 *     http://www.opensource.org/licenses/apache2.0.php
 *
 * You may elect to redistribute this code under either of these licenses.
 */

package io.vertx.core.http;

import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.Handler;
import io.vertx.core.MultiMap;
import io.vertx.core.metrics.Measured;

/**
 * An HTTP client that maintains a pool of connections to a specific host, at a specific port. The client supports
 * pipelining of requests.<p>
 * As well as HTTP requests, the client can act as a factory for {@code WebSocket websockets}.<p>
 * If an instance is instantiated from an event loop then the handlers
 * of the instance will always be called on that same event loop.
 * If an instance is instantiated from some other arbitrary Java thread (i.e. when running embedded) then
 * and event loop will be assigned to the instance and used when any of its handlers
 * are called.<p>
 * Instances of HttpClient are thread-safe.<p>
 *
 * @author <a href="http://tfox.org">Tim Fox</a>
 */
@VertxGen
public interface HttpClient extends Measured {

  HttpClientRequest request(HttpMethod method, int port, String host, String requestURI);

  HttpClientRequest request(HttpMethod method, int port, String host, String requestURI, Handler<HttpClientResponse> responseHandler);

  HttpClientRequest request(HttpMethod method, String requestURI);

  HttpClientRequest request(HttpMethod method, String requestURI, Handler<HttpClientResponse> responseHandler);

  HttpClientRequest requestAbs(HttpMethod method, String absoluteURI);

  HttpClientRequest requestAbs(HttpMethod method, String absoluteURI, Handler<HttpClientResponse> responseHandler);


  WebSocketStream websocket(int port, String host, String requestURI);

  WebSocketStream websocket(int port, String host, String requestURI, MultiMap headers);

  WebSocketStream websocket(int port, String host, String requestURI, MultiMap headers, WebsocketVersion version);

  WebSocketStream websocket(int port, String host, String requestURI, MultiMap headers, WebsocketVersion version,
                                   String subProtocols);

  WebSocketStream websocket(String requestURI);

  WebSocketStream websocket(String requestURI, MultiMap headers);

  WebSocketStream websocket(String requestURI, MultiMap headers, WebsocketVersion version);

  WebSocketStream websocket(String requestURI, MultiMap headers, WebsocketVersion version,
                            String subProtocols);


  HttpClient connectWebsocket(int port, String host, String requestURI, Handler<WebSocket> wsConnect);

  HttpClient connectWebsocket(int port, String host, String requestURI, MultiMap headers, Handler<WebSocket> wsConnect);

  HttpClient connectWebsocket(int port, String host, String requestURI, MultiMap headers, WebsocketVersion version,
                              Handler<WebSocket> wsConnect);

  HttpClient connectWebsocket(int port, String host, String requestURI, MultiMap headers, WebsocketVersion version,
                              String subProtocols, Handler<WebSocket> wsConnect);

  HttpClient connectWebsocket(String requestURI, Handler<WebSocket> wsConnect);

  HttpClient connectWebsocket(String requestURI, MultiMap headers, Handler<WebSocket> wsConnect);

  HttpClient connectWebsocket(String requestURI, MultiMap headers, WebsocketVersion version,
                              Handler<WebSocket> wsConnect);

  HttpClient connectWebsocket(String requestURI, MultiMap headers, WebsocketVersion version,
                              String subProtocols, Handler<WebSocket> wsConnect);


  void close();
}
