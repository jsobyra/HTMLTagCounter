public class TagKey {
    private String html;
    private String tag;

    public TagKey(String html, String tag){
        this.html = html;
        this.tag = tag;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        else {
            TagKey other = (TagKey) o;
            if (html != null ? !html.equals(other.html) : other.html != null) return false;
            return tag != null ? tag.equals(other.tag) : other.tag == null;
        }
    }

    @Override
    public int hashCode() {
        return html.hashCode() + tag.hashCode();
    }
}
