package gof.com.databindingtalk.base;

public abstract class BasePresenter<ViewType extends BaseView> {
    public ViewType view;

    public void setView(ViewType view) {
        this.view = view;
    }

    public void disposeView() {
        this.view = null;
    }

    public boolean isViewAvailable() {
        return this.view != null;
    }

    protected void notifyViewAboutDataAvailable(final Object data) {
        if (isViewAvailable()) {
            view.onDataAvailable(data);
        }
    }

    protected void notifyViewAboutError(final Exception error) {
        if (isViewAvailable()) {
            view.onDataError(error);
        }
    }
}

