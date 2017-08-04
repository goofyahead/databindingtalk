package gof.com.databindingtalk.base;

public interface BaseView<DataType> {
    void onDataAvailable(DataType data);

    void onDataError(Exception error);
}