// Design a file system with directory, files.

public abstract class Entry
{
	protected string Name {get;set;}
	protected Directory Parent {get;set;}
	protected int Size {get;set;}
	protected DateTime LastAccessTime {get;set;}
	protected DateTime LastModifiedTime {get;set;}
	protected DateTime CreatedTime {get;set;}
	
	public string GetFullPath()
	{
		return Parent.GetFullPath() + "/" + Name;
	}
	
	public void Delete()
	{
		parent.DeleteEntry(this);
	}
}

public class Directory: Entry
{
	private List<File> files;
	private List<Directory> directories;
	
	public Directory(string name)
	{
		files = new List<File>();
		base.Name = name;
	}
	
	public void AddFile(File f)
	{
		files.Add(f);
	}
	
	public void RemoveFile(File f)
	{
		files.Remove(f);
	}
}

public class File : Entry
{
	public File(string name)
	{
		base.Name = name;
	}
}