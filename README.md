# Data binding talk
Sample of data binding usage for gdg talk in Dubai

Meetup:
https://www.meetup.com/GDG-Dubai/events/242139793/

Slides:
https://drive.google.com/open?id=0BzOY3QAbReXTejFnRFd3R2tYOVE

ScreenVideo:
https://youtu.be/aJTGT-fvTl4


In order to follow the talk:

* clone the repository
    
    git clone git@github.com:goofyahead/databindingtalk.git
    
* then navigate to each step in the workshop with
    
    git checkout step-2
    git checkout step-3
    etc


## Typos & mistakes
You don't need to check on the binding adapters if the view is null, it will only execute the bindings when the view exist, is the parameter that can be null, so check for the parameter for nulls, like:
    
    @BindingAdapter("loadImageFromUrl")
    public static void loadImageFromUrl(ImageView imageView, String url) {
        if (url != null) {
            Picasso.with(imageView.getContext()).load(url).into(imageView);
        }
    }

ImageView *can not* be null, url *CAN* be null.
