package com.auth0.example;
import javax.servlet.AsyncContext;
import javax.servlet.DispatcherType;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpUpgradeHandler;
import javax.servlet.http.Part;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.Principal;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String signInUrl = "http://localhost:3000/portal/home";
        String registerAccountUrl = "http://localhost:3000/portal/register";

        try {
            HttpServletRequest request = new MockHttpServletRequest();
            HttpServletResponse response = new MockHttpServletResponse();
            FilterChain chain = new MockFilterChain();

            Auth0Filter auth0Filter = new Auth0Filter();
            auth0Filter.doFilter(request, response, chain);

            Desktop.getDesktop().browse(new URI(registerAccountUrl));
            Desktop.getDesktop().browse(new URI(signInUrl));
        } catch (IOException | URISyntaxException | ServletException e) {
            e.printStackTrace();
        }
    }

    // Mock HttpServletRequest implementation
    static class MockHttpServletRequest implements HttpServletRequest {

        @Override
        public HttpSession getSession(boolean create) {
            return null; 
        }

        @Override
        public Object getAttribute(String name) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getAttribute'");
        }

        @Override
        public Enumeration<String> getAttributeNames() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getAttributeNames'");
        }

        @Override
        public String getCharacterEncoding() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getCharacterEncoding'");
        }

        @Override
        public void setCharacterEncoding(String env) throws UnsupportedEncodingException {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'setCharacterEncoding'");
        }

        @Override
        public int getContentLength() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getContentLength'");
        }

        @Override
        public long getContentLengthLong() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getContentLengthLong'");
        }

        @Override
        public String getContentType() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getContentType'");
        }

        @Override
        public ServletInputStream getInputStream() throws IOException {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getInputStream'");
        }

        @Override
        public String getParameter(String name) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getParameter'");
        }

        @Override
        public Enumeration<String> getParameterNames() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getParameterNames'");
        }

        @Override
        public String[] getParameterValues(String name) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getParameterValues'");
        }

        @Override
        public Map<String, String[]> getParameterMap() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getParameterMap'");
        }

        @Override
        public String getProtocol() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getProtocol'");
        }

        @Override
        public String getScheme() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getScheme'");
        }

        @Override
        public String getServerName() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getServerName'");
        }

        @Override
        public int getServerPort() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getServerPort'");
        }

        @Override
        public BufferedReader getReader() throws IOException {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getReader'");
        }

        @Override
        public String getRemoteAddr() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getRemoteAddr'");
        }

        @Override
        public String getRemoteHost() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getRemoteHost'");
        }

        @Override
        public void setAttribute(String name, Object o) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'setAttribute'");
        }

        @Override
        public void removeAttribute(String name) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'removeAttribute'");
        }

        @Override
        public Locale getLocale() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getLocale'");
        }

        @Override
        public Enumeration<Locale> getLocales() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getLocales'");
        }

        @Override
        public boolean isSecure() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'isSecure'");
        }

        @Override
        public RequestDispatcher getRequestDispatcher(String path) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getRequestDispatcher'");
        }

        @Override
        public String getRealPath(String path) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getRealPath'");
        }

        @Override
        public int getRemotePort() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getRemotePort'");
        }

        @Override
        public String getLocalName() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getLocalName'");
        }

        @Override
        public String getLocalAddr() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getLocalAddr'");
        }

        @Override
        public int getLocalPort() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getLocalPort'");
        }

        @Override
        public ServletContext getServletContext() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getServletContext'");
        }

        @Override
        public AsyncContext startAsync() throws IllegalStateException {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'startAsync'");
        }

        @Override
        public AsyncContext startAsync(ServletRequest servletRequest, ServletResponse servletResponse)
                throws IllegalStateException {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'startAsync'");
        }

        @Override
        public boolean isAsyncStarted() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'isAsyncStarted'");
        }

        @Override
        public boolean isAsyncSupported() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'isAsyncSupported'");
        }

        @Override
        public AsyncContext getAsyncContext() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getAsyncContext'");
        }

        @Override
        public DispatcherType getDispatcherType() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getDispatcherType'");
        }

        @Override
        public String getAuthType() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getAuthType'");
        }

        @Override
        public Cookie[] getCookies() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getCookies'");
        }

        @Override
        public long getDateHeader(String name) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getDateHeader'");
        }

        @Override
        public String getHeader(String name) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getHeader'");
        }

        @Override
        public Enumeration<String> getHeaders(String name) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getHeaders'");
        }

        @Override
        public Enumeration<String> getHeaderNames() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getHeaderNames'");
        }

        @Override
        public int getIntHeader(String name) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getIntHeader'");
        }

        @Override
        public String getMethod() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getMethod'");
        }

        @Override
        public String getPathInfo() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getPathInfo'");
        }

        @Override
        public String getPathTranslated() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getPathTranslated'");
        }

        @Override
        public String getContextPath() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getContextPath'");
        }

        @Override
        public String getQueryString() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getQueryString'");
        }

        @Override
        public String getRemoteUser() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getRemoteUser'");
        }

        @Override
        public boolean isUserInRole(String role) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'isUserInRole'");
        }

        @Override
        public Principal getUserPrincipal() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getUserPrincipal'");
        }

        @Override
        public String getRequestedSessionId() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getRequestedSessionId'");
        }

        @Override
        public String getRequestURI() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getRequestURI'");
        }

        @Override
        public StringBuffer getRequestURL() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getRequestURL'");
        }

        @Override
        public String getServletPath() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getServletPath'");
        }

        @Override
        public HttpSession getSession() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getSession'");
        }

        @Override
        public String changeSessionId() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'changeSessionId'");
        }

        @Override
        public boolean isRequestedSessionIdValid() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'isRequestedSessionIdValid'");
        }

        @Override
        public boolean isRequestedSessionIdFromCookie() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'isRequestedSessionIdFromCookie'");
        }

        @Override
        public boolean isRequestedSessionIdFromURL() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'isRequestedSessionIdFromURL'");
        }

        @Override
        public boolean isRequestedSessionIdFromUrl() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'isRequestedSessionIdFromUrl'");
        }

        @Override
        public boolean authenticate(HttpServletResponse response) throws IOException, ServletException {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'authenticate'");
        }

        @Override
        public void login(String username, String password) throws ServletException {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'login'");
        }

        @Override
        public void logout() throws ServletException {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'logout'");
        }

        @Override
        public Collection<Part> getParts() throws IOException, ServletException {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getParts'");
        }

        @Override
        public Part getPart(String name) throws IOException, ServletException {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getPart'");
        }

        @Override
        public <T extends HttpUpgradeHandler> T upgrade(Class<T> handlerClass) throws IOException, ServletException {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'upgrade'");
        }
    }

    // Mock HttpServletResponse implementation
    static class MockHttpServletResponse implements HttpServletResponse {
        
        @Override
        public void sendRedirect(String location) throws IOException {
           
        }

        @Override
        public String getCharacterEncoding() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getCharacterEncoding'");
        }

        @Override
        public String getContentType() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getContentType'");
        }

        @Override
        public ServletOutputStream getOutputStream() throws IOException {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getOutputStream'");
        }

        @Override
        public PrintWriter getWriter() throws IOException {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getWriter'");
        }

        @Override
        public void setCharacterEncoding(String charset) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'setCharacterEncoding'");
        }

        @Override
        public void setContentLength(int len) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'setContentLength'");
        }

        @Override
        public void setContentLengthLong(long len) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'setContentLengthLong'");
        }

        @Override
        public void setContentType(String type) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'setContentType'");
        }

        @Override
        public void setBufferSize(int size) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'setBufferSize'");
        }

        @Override
        public int getBufferSize() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getBufferSize'");
        }

        @Override
        public void flushBuffer() throws IOException {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'flushBuffer'");
        }

        @Override
        public void resetBuffer() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'resetBuffer'");
        }

        @Override
        public boolean isCommitted() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'isCommitted'");
        }

        @Override
        public void reset() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'reset'");
        }

        @Override
        public void setLocale(Locale loc) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'setLocale'");
        }

        @Override
        public Locale getLocale() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getLocale'");
        }

        @Override
        public void addCookie(Cookie cookie) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'addCookie'");
        }

        @Override
        public boolean containsHeader(String name) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'containsHeader'");
        }

        @Override
        public String encodeURL(String url) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'encodeURL'");
        }

        @Override
        public String encodeRedirectURL(String url) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'encodeRedirectURL'");
        }

        @Override
        public String encodeUrl(String url) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'encodeUrl'");
        }

        @Override
        public String encodeRedirectUrl(String url) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'encodeRedirectUrl'");
        }

        @Override
        public void sendError(int sc, String msg) throws IOException {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'sendError'");
        }

        @Override
        public void sendError(int sc) throws IOException {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'sendError'");
        }

        @Override
        public void setDateHeader(String name, long date) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'setDateHeader'");
        }

        @Override
        public void addDateHeader(String name, long date) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'addDateHeader'");
        }

        @Override
        public void setHeader(String name, String value) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'setHeader'");
        }

        @Override
        public void addHeader(String name, String value) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'addHeader'");
        }

        @Override
        public void setIntHeader(String name, int value) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'setIntHeader'");
        }

        @Override
        public void addIntHeader(String name, int value) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'addIntHeader'");
        }

        @Override
        public void setStatus(int sc) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'setStatus'");
        }

        @Override
        public void setStatus(int sc, String sm) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'setStatus'");
        }

        @Override
        public int getStatus() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getStatus'");
        }

        @Override
        public String getHeader(String name) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getHeader'");
        }

        @Override
        public Collection<String> getHeaders(String name) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getHeaders'");
        }

        @Override
        public Collection<String> getHeaderNames() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getHeaderNames'");
        }
    }

    // Mock FilterChain implementation
    static class MockFilterChain implements FilterChain {
        @Override
        public void doFilter(ServletRequest request, ServletResponse response) throws IOException, ServletException {
        }
    }
}
