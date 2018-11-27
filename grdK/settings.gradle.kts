rootProject.name = "grdK"
include("module")
include ("more")
project(":more").projectDir = file("multi/more")
// include two projects, 'foo' and 'foo:bar'
// directories are inferred by replacing ':' with '/'
//include("foo:bar")
//
// include one project whose project dir does not match the logical project path
//include ("baz")
//project(":baz").projectDir = file("foo/baz")
//
// include many projects whose project dirs do not match the logical project paths
//file("multi").listFiles().forEach { dir ->
//  include(dir.name)
//  project(":${dir.name}").projectDir = dir
//}