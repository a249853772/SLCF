package com.huhao.springboot.pojo;

import java.util.List;
import java.util.Objects;

public class PageResult<T> {
	
	
	private final static PageResult<?> EMPTY = new PageResult<>();

    private Data<T> data;

    /**
     * 错误信息
     */
    private String msg;
    /**
     * 状态 1成功 其它失败，失败需要返回msg
     */
    private int state;

    /**
     * 是否跳转
     */
    private boolean is_redirect = false;

    /**
     * 跳转地址
     */
    private String redirect_url;

    /**
     * token
     */
    private String token;

    public Data<T> getData() {
        return data;
    }

    public String getMsg() {
        return msg;
    }

    public int getState() {
        return state;
    }

    public boolean isIs_redirect() {
        return is_redirect;
    }

    public String getRedirect_url() {
        return redirect_url;
    }

    public String getToken() {
        return token;
    }

    private PageResult() {
        this.data = null;
    }

    private PageResult(String message, int state) {
        this.msg = message;
        this.state = state;
    }

    private PageResult(List<T> list, int state) {
        Data<T> data = new Data<>(list);
        this.data = data;
        this.state = state;
    }

    /**
     * 功能描述: 创建一个空PageResult类
     *
     * @auther: yuantao
     * @date: 2018/4/21
     */
    public static <T> PageResult<T> empty() {
        @SuppressWarnings("unchecked")
        PageResult<T> t = (PageResult<T>) EMPTY;
        return t;
    }

    /**
     * 功能描述: 生成一个成功状态PageResult类
     *
     * @auther: yuantao
     * @param: List<T>
     * @return: PageResult<T>
     * @date: 2018/4/21
     */
    public static <T> PageResult<T> success(List<T> data) {
        return new PageResult<>(data, 1);
    }

    /**
     * 功能描述: 生成一个失败状态PageResult类
     *
     * @auther: yuantao
     * @param: 错误信息
     * @return: PageResult<T>
     * @date: 2018/4/21
     */
    public static <T> PageResult<T> fail(String message) {
        return new PageResult<>(message, 0);
    }

    /**
     * 功能描述: 设置页码信息
     *
     * @auther: yuantao
     * @param: pageNum, pageSize
     * @return: PageResult<T>
     * @date: 2018/4/21
     */
    public <T> PageResult<T> pageBar(int pageNum, int pageSize) {
        if (state == 1) {
            data.pageBar(pageNum, pageSize);
        }
        return (PageResult<T>) this;
    }

    /**
     * 功能描述: 设置总数
     *
     * @auther: yuantao
     * @param: total
     * @return: PageResult<T>
     * @date: 2018/4/21
     */
    public <T> PageResult<T> total(int total) {
        if (data.pagebar != null) {
            data.pagebar.total(total);
        }
        return (PageResult<T>) this;
    }

    /**
     * 功能描述: 设置跳转地址
     *
     * @auther: yuantao
     * @param: 跳转地址
     * @return: PageResult<T>
     * @date: 2018/4/21
     */
    public <T> PageResult<T> redirect(String url) {
        this.is_redirect = true;
        this.redirect_url = url;
        return (PageResult<T>) this;
    }

    /**
     * 功能描述: 设置失败跳转地址
     *
     * @auther: yuantao
     * @param: 跳转地址
     * @return: PageResult<T>
     * @date: 2018/4/21
     */
    public <T> PageResult<T> orFailRedirect(String url) {
        if (state == 1) {
            return (PageResult<T>) this;
        }
        this.is_redirect = true;
        this.redirect_url = url;
        return (PageResult<T>) this;
    }

    /**
     * 功能描述: 判断是否传入值是否为空,非空则返回值，为空则返回失败信息
     *
     * @auther: yuantao
     * @param: 返回的错误信息
     * @return: PageResult<T>
     * @date: 2018/4/21
     */
    public <T> PageResult<T> orFail(String message) {
        if (null != data.list) {
            return (PageResult<T>) this;
        } else {
            this.msg = message;
            this.state = 0;
        }
        return (PageResult<T>) this;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(data);
    }


    @Override
    public String toString() {
        return data != null
                ? String.format("result[%s]", data)
                : "result.empty";
    }

    public static class Data<T> {
        /**
         * 接口数据
         */
        private List<T> list;

        /**
         * 分页信息
         */
        private PageBar pagebar;

        private Data(List<T> list) {
            this.list = list;
        }

        public List<T> getList() {
            return list;
        }

        public PageBar getPagebar() {
            return pagebar;
        }

        public void pageBar(int pageNum, int pageSize) {
            PageBar pageBar = new PageBar(pageNum, pageSize);
            this.pagebar = pageBar;
        }

        public static class PageBar {
            private int page;
            private int total;
            private int limit;

            private PageBar(int page, int limit) {
                this.page = page;
                this.limit = limit;
            }

            private void total(int total) {
                this.total = total;
            }

            public int getPage() {
                return page;
            }

            public int getTotal() {
                return total;
            }

            public int getLimit() {
                return limit;
            }
        }
    }

}
